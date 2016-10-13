package local.zone.simpleapp.handler;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Price on 13.10.2016.
 */
public class HttpIndexHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("Hello, world!");
        httpExchange.getRequestURI();
    }


}
