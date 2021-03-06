package local.zone.simpleapp.json.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import local.zone.simpleapp.dao.entity.Commission;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Price on 15.10.2016.
 */
public class CommissionSerializerTest {

    @Test
    public void serialize() throws Exception {
        Commission commission = new Commission();
        commission.setCommissionId(1);
        commission.setBrand("MasterCard");
        commission.setCurrency("BYN");
        Gson gson = new GsonBuilder().registerTypeAdapter(Commission.class, new CommissionSerializer()).create();
        String json = gson.toJson(commission);
        System.out.println(json);
        Assert.assertNotNull(gson);
        Assert.assertNotNull(json);
        Assert.assertNotEquals("", json);
    }
}