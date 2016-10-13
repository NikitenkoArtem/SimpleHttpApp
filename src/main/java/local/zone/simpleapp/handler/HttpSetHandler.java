package local.zone.simpleapp.handler;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import local.zone.simpleapp.dao.entity.Card;

import java.io.IOException;
import java.net.URI;

/**
 * Created by Price on 13.10.2016.
 */
public class HttpSetHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        URI uri = httpExchange.getRequestURI();
        String query = uri.getQuery();
        httpExchange.getAttribute("receiver_card_id");
        httpExchange.getAttribute("receiver_owner");
        httpExchange.getAttribute("receiver_expire");
        httpExchange.getAttribute("recipient_card_id");
        httpExchange.getAttribute("recipient_owner");
        httpExchange.getAttribute("recipient_expire");

        StringBuilder builder = new StringBuilder();
        Gson gson = new Gson();
        gson.toJson(new Card());
//        builder.append();
    }
}
