package local.zone.simpleapp.util;

import local.zone.simpleapp.dao.entity.Commission;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Price on 13.10.2016.
 */
public class UtilTest {

    @Test
    public void parseXml() throws Exception {
        File file = new File("commission.xml");
        Util parser = new Util();
        ArrayList<Commission> list = parser.parseXml(file);
        Assert.assertNotNull(list);
        for (Commission commission : list) {
            System.out.println(commission.getCommissionId());
            System.out.println(commission.getBrand());
            System.out.println(commission.getCurrencyId().getCurrency());
            System.out.println(commission.getValue());
        }
    }

    @Test(expected = RuntimeException.class)
    public void parseXmlEmptyString() throws Exception {
        File file = new File("");
        Util parser = new Util();
        ArrayList<Commission> list = parser.parseXml(file);
        Assert.assertNull(list);
    }

    @Test(expected = RuntimeException.class)
    public void parseXmlNull() throws Exception {
        File file = null;
        Util parser = new Util();
        ArrayList<Commission> list = parser.parseXml(file);
        Assert.assertNull(list);
    }
}