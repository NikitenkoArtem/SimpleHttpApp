package local.zone.simpleapp.util;

import local.zone.simpleapp.dao.entity.Commission;
import local.zone.simpleapp.dao.entity.Currency;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

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

    public ArrayList<Commission> parseXml(File file) {
        if (file == null || !file.exists()) {
            throw new RuntimeException(new FileNotFoundException());
        } else {
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = factory.newDocumentBuilder();
                Document doc = docBuilder.parse(file);
                NodeList nodeList = doc.getElementsByTagName("commission");
                ArrayList<Commission> list = new ArrayList<>();
                for (int index = 0; index < nodeList.getLength(); index++) {
                    Element element = (Element) nodeList.item(index);
                    Commission commission = new Commission();
                    try {
                        commission.setCommissionId(Integer.parseInt(element.getAttribute("id")));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    commission.setBrand(element.getElementsByTagName("brand").item(index).getTextContent());
                    Currency currencyName = new Currency();
                    currencyName.setCurrency(element.getElementsByTagName("currency").item(index).getTextContent());
                    commission.setCurrencyId(currencyName);
                    try {
                        commission.setValue(Float.parseFloat(element.getElementsByTagName("value").item(index).getTextContent()));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    list.add(commission);
                }
                return list;
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
