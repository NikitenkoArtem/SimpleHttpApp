package local.zone.simpleapp.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;

/**
 * Created by Price on 13.10.2016.
 */
public class Util {
    public static Commissions parseXml(File file) {
        if (file == null || !file.exists()) {
            throw new RuntimeException(new FileNotFoundException());
        } else {
            try {
                JAXBContext context = JAXBContext.newInstance(Commissions.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
//                Commissions commissions = (Commissions) unmarshaller.unmarshal(file);
//                Marshaller marshaller = context.createMarshaller();
//                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//                marshaller.marshal(commissions, System.out);
                return (Commissions) unmarshaller.unmarshal(file);
            } catch (JAXBException e) {
                Log.getLogger(Util.class).log(Level.SEVERE, e.getMessage());
            }
        }
        return null;
    }
}