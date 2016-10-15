package local.zone.simpleapp.json.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import local.zone.simpleapp.dao.entity.Commission;
import local.zone.simpleapp.dao.entity.Currency;
import local.zone.simpleapp.dao.entity.Transfer;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Created by Price on 15.10.2016.
 */
public class TransferSerializerTest {

    @Test
    public void serialize() throws Exception {
        Transfer transfer = new Transfer();
        transfer.setTransferId(1);
        transfer.setTransferDate(new Date(System.currentTimeMillis()));
        transfer.setSum(1.5);
        Commission commission = new Commission();
        commission.setCommissionId(1);
        commission.setBrand("MasterCard");
        Currency currency = new Currency();
        currency.setCurrency("RUB");
        commission.setCurrencyId(currency);
        transfer.setCommissionId(commission);
        Gson gson = new GsonBuilder().registerTypeAdapter(Transfer.class, new TransferSerializer()).create();
        String json = gson.toJson(transfer);
        System.out.println(json);
        Assert.assertNotNull(gson);
        Assert.assertNotNull(json);
        Assert.assertNotEquals("", json);
    }
}