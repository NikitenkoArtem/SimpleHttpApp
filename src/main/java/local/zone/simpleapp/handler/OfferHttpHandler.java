package local.zone.simpleapp.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import local.zone.simpleapp.dao.entity.Card;
import local.zone.simpleapp.dao.entity.Currency;
import local.zone.simpleapp.dao.entity.Transfer;
import local.zone.simpleapp.dao.entity.User;
import local.zone.simpleapp.json.serialize.CardSerializer;
import local.zone.simpleapp.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Price on 13.10.2016.
 */
public class OfferHttpHandler implements HttpHandler {

    private Logger logger = Log.getLogger(this.getClass());//, "app.log");

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        logger.log(Level.INFO, httpExchange.getRequestURI().getPath());
        Map<String, String> parameters = getParameters(httpExchange);
        logger.log(Level.INFO, parameters.toString());
        Currency currency = new Currency();
        currency.setCurrency(parameters.get("currency"));
        Transfer transfer = new Transfer();
        transfer.setSum(Double.valueOf(parameters.get("sum")));
        Card receiverCard = getCard(httpExchange, "receiver_card_id", "receiver_owner", "receiver_expire");
        Card recipientCard = getCard(httpExchange, "recipient_card_id", "recipient_owner", "recipient_expire");
        /*try (Connection connection = DBConnection.getConnection()) {
            new CardDao(connection, Card.class).create(receiverCard);
            new CardDao(connection, Card.class).create(recipientCard);
            new TransferDao(connection, Transfer.class).create(transfer);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }*/
        Gson gson = new GsonBuilder().registerTypeAdapter(Card.class, new CardSerializer()).create();
        String receiver = gson.toJson(receiverCard);
        httpExchange.getResponseHeaders().set("Content-Type", "application/json");
        httpExchange.sendResponseHeaders(200, receiver.length());
        try (OutputStream out = httpExchange.getResponseBody()) {
            out.write(receiver.getBytes());
        }
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

    private Card getCard(HttpExchange httpExchange, String card_id, String owner, String expire) {
        Map<String, String> parameters = getParameters(httpExchange);
        Card receiverCard = new Card();
        receiverCard.setCardId(Integer.valueOf(parameters.get(card_id)));
        User receiver = new User();
        receiver.setFirstName(parameters.get(owner));
        receiverCard.setUserId(receiver);
        receiverCard.setExpirationDate(Date.valueOf(parameters.get(expire)));
        return receiverCard;
    }
}
