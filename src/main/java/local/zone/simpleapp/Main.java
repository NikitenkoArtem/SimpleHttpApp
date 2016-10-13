package local.zone.simpleapp;

import com.sun.net.httpserver.HttpServer;
import local.zone.simpleapp.handler.HttpIndexHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Price on 13.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(8080), 0);
            server.createContext("/SimpleHttpApp", new HttpIndexHandler());
            server.createContext("/SimpleHttpApp/get", new HttpIndexHandler());
            server.createContext("/SimpleHttpApp/set", new HttpIndexHandler());
            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
