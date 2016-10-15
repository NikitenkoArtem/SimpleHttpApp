package local.zone.simpleapp;

import com.sun.net.httpserver.HttpServer;
import local.zone.simpleapp.dao.connection.DBConnection;
import local.zone.simpleapp.handler.IndexHttpHandler;
import local.zone.simpleapp.handler.OfferHttpHandler;
import local.zone.simpleapp.util.Util;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Price on 13.10.2016.
 */
public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(8080), 0);
            logger.log(Level.INFO, "Server listening port: 8080");
            server.createContext("/SimpleHttpApp", new IndexHttpHandler());
            server.createContext("/SimpleHttpApp/offer", new OfferHttpHandler());
            server.setExecutor(null);
            prepareDatabase();
            server.start();
            logger.log(Level.INFO, "Server started successfully");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private static void prepareDatabase() throws IOException {
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            Path path = FileSystems.getDefault().getPath("./resources", "db.sql");
            String sql = new String(Files.readAllBytes(path));
            statement.execute(sql);
            logger.log(Level.INFO, "Database schema created successfully");
            //TODO: executeUpdate from commission.xml to database
            Util.parseXml(new File("./resources/commission.xml"));
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
