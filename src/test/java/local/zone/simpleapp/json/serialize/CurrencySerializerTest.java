package local.zone.simpleapp.json.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import local.zone.simpleapp.dao.entity.Currency;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Price on 15.10.2016.
 */
public class CurrencySerializerTest {

    @Test
    public void serialize() throws Exception {
        Currency currency = new Currency();
        currency.setCurrencyId(1);
        currency.setCurrency("BYN");
        Gson gson = new GsonBuilder().registerTypeAdapter(Currency.class, new CurrencySerializer()).create();
        String json = gson.toJson(currency);
        System.out.println(json);
        Assert.assertNotNull(gson);
        Assert.assertNotNull(json);
        Assert.assertNotEquals("", json);
    }
}