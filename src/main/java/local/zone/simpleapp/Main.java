package local.zone.simpleapp;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Price on 13.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(8080), 0);
            HttpContext context = server.createContext("/simpleHttpApp", new EchoHandler());
            context.setAuthenticator(new Auth());
            server.setExecutor(null);
            server.start();
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.
                    getConnection("jdbc:h2:~/test", "sa", "");
            // add application code here
            conn.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
