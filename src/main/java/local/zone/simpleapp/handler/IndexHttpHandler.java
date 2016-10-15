package local.zone.simpleapp.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import local.zone.simpleapp.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Price on 13.10.2016.
 */
public class IndexHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) {
        Logger logger = Log.getLogger(this.getClass());//, "app.log");
        logger.log(Level.INFO, httpExchange.getRequestURI().getPath());
        OutputStream responseBody = httpExchange.getResponseBody();
        Path path = FileSystems.getDefault().getPath("web", "index.html");
        try {
            httpExchange.sendResponseHeaders(200, 0);
            String read = new String(Files.readAllBytes(path));
            byte[] bytes = String.valueOf(read).getBytes();
            responseBody.write(bytes);
            responseBody.flush();
            responseBody.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }


}
