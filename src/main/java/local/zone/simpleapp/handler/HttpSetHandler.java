package local.zone.simpleapp.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import local.zone.simpleapp.dao.connection.DBConnection;
import local.zone.simpleapp.dao.dao.CardDao;
import local.zone.simpleapp.dao.dao.TransferDao;
import local.zone.simpleapp.dao.entity.Card;
import local.zone.simpleapp.dao.entity.Currency;
import local.zone.simpleapp.dao.entity.Transfer;
import local.zone.simpleapp.dao.entity.User;
import local.zone.simpleapp.json.serialize.CardSerializer;

import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Price on 13.10.2016.
 */
public class HttpSetHandler implements HttpHandler {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        logger.log(Level.INFO, httpExchange.getRequestURI().getPath());

        Currency currency = new Currency();
        currency.setCurrency(httpExchange.getAttribute("currency").toString());
        Transfer transfer = new Transfer();

        transfer.setSum((Integer) httpExchange.getAttribute("sum"));
        Card receiverCard = getReceiverCard(httpExchange);
        Card recipientCard = getRecipientCard(httpExchange);
        try (Connection connection = DBConnection.getConnection()) {
            new CardDao(connection, Card.class).create(receiverCard);
            new CardDao(connection, Card.class).create(recipientCard);
            new TransferDao(connection, Transfer.class).create(transfer);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        Gson gson = new GsonBuilder().registerTypeAdapter(Card.class, new CardSerializer()).create();
    }

    private Card getRecipientCard(HttpExchange httpExchange) {
        Card recipientCard = new Card();
        recipientCard.setCardId((Integer) httpExchange.getAttribute("recipient_card_id"));
        User recipient = new User();
        recipient.setFirstName(httpExchange.getAttribute("recipient_owner").toString());
        recipientCard.setUserId(recipient);
        recipientCard.setExpirationDate((Date) httpExchange.getAttribute("recipient_expire"));
        return recipientCard;
    }

    private Card getReceiverCard(HttpExchange httpExchange) {
        Card receiverCard = new Card();
        receiverCard.setCardId((Integer) httpExchange.getAttribute("receiver_card_id"));
        User receiver = new User();
        receiver.setFirstName(httpExchange.getAttribute("receiver_owner").toString());
        receiverCard.setUserId(receiver);
        receiverCard.setExpirationDate((Date) httpExchange.getAttribute("receiver_expire"));
        return receiverCard;
    }
}
