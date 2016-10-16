package local.zone.simpleapp.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import local.zone.simpleapp.dao.connection.DBConnection;
import local.zone.simpleapp.dao.dao.CardDao;
import local.zone.simpleapp.dao.dao.CommissionDao;
import local.zone.simpleapp.dao.dao.TransferDao;
import local.zone.simpleapp.dao.dao.UserDao;
import local.zone.simpleapp.dao.entity.*;
import local.zone.simpleapp.json.serialize.CardSerializer;
import local.zone.simpleapp.json.serialize.TransferSerializer;
import local.zone.simpleapp.json.serialize.UserSerializer;
import local.zone.simpleapp.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Price on 13.10.2016.
 */
public class OfferHttpHandler implements HttpHandler {

    private Logger logger = Log.getLogger(this.getClass(), "app.log");

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        try {
            logger.log(Level.INFO, httpExchange.getRequestURI().getPath());
            Map<String, String> parameters = getParameters(httpExchange);
            logger.log(Level.INFO, parameters.toString());
            User receiver = getUser(parameters, "receiver_owner_firstName", "receiver_owner_lastName");
            User recipient = getUser(parameters, "recipient_owner_firstName", "recipient_owner_lastName");
            Transfer transfer = getTransfer(parameters, "sum");
            Commission commission = getCommission(parameters, "brand", "currency");
            Card receiverCard = null;
            try (Connection connection = DBConnection.getConnection()) {
                commission = new CommissionDao(connection, Commission.class).readByCurrency(commission.getCurrency());
                System.out.println(commission);
                transfer.setCommissionId(commission);
                new TransferDao(connection, Transfer.class).create(transfer);
                Integer receiverId = new UserDao(connection, User.class).create(receiver);
                receiver.setUserId(receiverId);
                receiverCard = getCard(httpExchange, "receiver_card_id", "receiver_expire", receiver);
                receiverCard.setUserId(receiver);
                new CardDao(connection, Card.class).create(receiverCard);
                Integer recipientId = new UserDao(connection, User.class).create(recipient);
                recipient.setUserId(recipientId);
                Card recipientCard = getCard(httpExchange, "recipient_card_id", "recipient_expire", recipient);
                recipientCard.setUserId(recipient);
                new CardDao(connection, Card.class).create(recipientCard);
            } catch (SQLException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
            double result = transfer.getSum() / commission.getValue();
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Card.class, new CardSerializer())
                    .registerTypeAdapter(User.class, new UserSerializer())
                    .registerTypeAdapter(Transfer.class, new TransferSerializer())
                    .setPrettyPrinting()
                    .create();
            StringBuilder builder = new StringBuilder();
            JsonObject object = new JsonObject();
            object.addProperty("result", result);
            builder.append(gson.toJson(receiverCard))
                    .append(gson.toJson(receiverCard))
                    .append(gson.toJson(transfer))
                    .append(gson.toJson(object));
            httpExchange.getResponseHeaders().set("Content-Type", "application/json");
            try (OutputStream out = httpExchange.getResponseBody()) {
                httpExchange.sendResponseHeaders(200, builder.length());
                out.write(builder.toString().getBytes());
                out.flush();
            } catch (IOException e) {
                logger.log(Level.INFO, e.getMessage());
                httpExchange.sendResponseHeaders(500, 0);
            }
        } catch (Exception e) {
            httpExchange.sendResponseHeaders(500, 0);
            httpExchange.getResponseBody().close();
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private Commission getCommission(Map<String, String> parameters, String brand, String currency) {
        Commission commission = new Commission();
        commission.setBrand(parameters.get(brand));
        commission.setCurrency(parameters.get(currency));
        return commission;
    }

    private Transfer getTransfer(Map<String, String> parameters, String sum) {
        Transfer transfer = new Transfer();
        transfer.setTransferDate(new Date(System.currentTimeMillis()));
        transfer.setSum(Double.valueOf(parameters.get(sum)));
        return transfer;
    }

    private User getUser(Map<String, String> parameters, String firstName, String lastName) {
        User user = new User();
        user.setFirstName(parameters.get(firstName));
        user.setLastName(parameters.get(lastName));
        return user;
    }

    private Map<String, String> getParameters(HttpExchange httpExchange) {
        String query = httpExchange.getRequestURI().getQuery();
        Map<String, String> parameters = new HashMap<>();
        for (String param : query.split("&")) {
            String[] pair = param.split("=");
            if (pair.length > 1) {
                parameters.put(pair[0], pair[1]);
            } else {
                parameters.put(pair[0], "");
            }
        }
        return parameters;
    }

    private Card getCard(HttpExchange httpExchange, String card_id, String expire, User user) {
        Map<String, String> parameters = getParameters(httpExchange);
        Card receiverCard = new Card();
        receiverCard.setCardId(Integer.valueOf(parameters.get(card_id)));
        receiverCard.setUserId(user);
        receiverCard.setExpirationDate(Date.valueOf(parameters.get(expire)));
        return receiverCard;
    }
}
