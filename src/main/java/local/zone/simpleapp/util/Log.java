package local.zone.simpleapp.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by Price on 15.10.2016.
 */
public class Log {
    public static Logger getLogger(Class clazz) {
        return Logger.getLogger(clazz.getName());
    }

    public static Logger getLogger(Class clazz, String filePath) {
        Logger logger = Logger.getLogger(clazz.getName());
        try {
            FileHandler fileHandler = new FileHandler(filePath);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return logger;
    }
}
