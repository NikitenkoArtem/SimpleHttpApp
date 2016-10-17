package local.zone.simpleapp.json.deserialize;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import local.zone.simpleapp.dao.entity.Commission;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        json.addProperty("currency", "BYN");
        json.addProperty("value", 1.5);
    }

    @Test
    public void deserialize() throws Exception {
        Commission commission = new Gson().fromJson(json, Commission.class);
        Integer commissionId = commission.getCommissionId();
        String brand = commission.getBrand();
        String currency = commission.getCurrency();
        Float value = commission.getValue();
        System.out.println(commissionId);
        System.out.println(brand);
        System.out.println(currency);
        System.out.println(value);
        Assert.assertNotNull(commissionId);
        Assert.assertNotNull(brand);
        Assert.assertNotNull(currency);
        Assert.assertNotEquals("", currency);
        Assert.assertNotNull(value);
    }

    @Test
    public void deserializeNull() throws Exception {
        json = null;
        Commission commission = new Gson().fromJson(json, Commission.class);
        Assert.assertNull(commission);
    }
}