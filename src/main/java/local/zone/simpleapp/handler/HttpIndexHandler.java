package local.zone.simpleapp.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Price on 13.10.2016.
 */
public class HttpIndexHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) {
        System.out.println("Index handler");
        OutputStream responseBody = httpExchange.getResponseBody();
        Path path = FileSystems.getDefault().getPath("web", "index.html");
        try {
            httpExchange.sendResponseHeaders(200, 0);
            String read = new String(Files.readAllBytes(path));
//            System.out.println(read);
            byte[] bytes = String.valueOf(read).getBytes();
            responseBody.write(bytes);
            responseBody.flush();
            responseBody.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
