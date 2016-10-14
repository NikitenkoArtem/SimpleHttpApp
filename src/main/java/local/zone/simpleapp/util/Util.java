package local.zone.simpleapp.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import local.zone.simpleapp.dao.entity.Commission;
import local.zone.simpleapp.dao.entity.Currency;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Price on 13.10.2016.
 */
public class Util {
    public static void parseXml(File file) {
        if (file == null || !file.exists()) {
            throw new RuntimeException(new FileNotFoundException());
        } else {
            try {
                JAXBContext context = JAXBContext.newInstance(Commissions.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Commissions commission = (Commissions) unmarshaller.unmarshal(file);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(commission, System.out);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
}