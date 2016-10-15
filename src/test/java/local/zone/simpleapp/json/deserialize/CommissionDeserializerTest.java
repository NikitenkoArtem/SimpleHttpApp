package local.zone.simpleapp.json.deserialize;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import local.zone.simpleapp.dao.entity.Card;
import local.zone.simpleapp.dao.entity.Commission;
import local.zone.simpleapp.dao.entity.Currency;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Price on 15.10.2016.
 */
public class CommissionDeserializerTest {

    private JsonObject json;

    @Before
    public void prepare() {
        json = new JsonObject();
        json.addProperty("commissionId", 1);
        json.addProperty("brand", "MasterCard");
        JsonObject object = new JsonObject();
        object.addProperty("currency", "BYN");
        json.add("currencyId", object);
        json.addProperty("value", 1.5);
    }

    @Test
    public void deserialize() throws Exception {
        Commission commission = new Gson().fromJson(json, Commission.class);
        Integer commissionId = commission.getCommissionId();
        String brand = commission.getBrand();
        Currency currencyId = commission.getCurrencyId();
        Float value = commission.getValue();
        System.out.println(commissionId);
        System.out.println(brand);
        System.out.println(currencyId);
        System.out.println(value);
        Assert.assertNotNull(commissionId);
        Assert.assertNotNull(brand);
        Assert.assertNotNull(currencyId);
        Assert.assertNotNull(value);
    }

    @Test
    public void deserializeNull() throws Exception {
        json = null;
        Commission commission = new Gson().fromJson(json, Commission.class);
        System.out.println(commission);
        Assert.assertNull(commission);
    }
}