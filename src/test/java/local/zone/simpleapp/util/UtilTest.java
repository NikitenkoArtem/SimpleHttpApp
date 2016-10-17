package local.zone.simpleapp.util;

import org.junit.Test;

import java.io.File;

/**
 * Created by Price on 13.10.2016.
 */
public class UtilTest {

    @Test
    public void parseXml() throws Exception {
        File file = new File("resources/commission.xml");
        Util parser = new Util();
        parser.parseXml(file);
    }

    @Test(expected = RuntimeException.class)
    public void parseXmlEmptyString() throws Exception {
        File file = new File("");
        new Util().parseXml(file);
    }

    @Test(expected = RuntimeException.class)
    public void parseXmlNull() throws Exception {
        File file = null;
        new Util().parseXml(file);
    }
}