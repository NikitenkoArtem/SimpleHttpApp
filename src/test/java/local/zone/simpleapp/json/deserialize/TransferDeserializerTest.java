package local.zone.simpleapp.json.deserialize;

import com.google.gson.Gson;
import local.zone.simpleapp.dao.entity.Transfer;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

/**
 * Created by Price on 15.10.2016.
 */
public class TransferDeserializerTest {

    @Test
    public void deserialize() throws Exception {
        /*Date date = Date.valueOf("2016-10-17");
        String json = "{\"transferId\":1," +
                "\"transferDate\":" + date + "," +
                "\"sum\":1.5,\"commissionId\":{\"commissionId\":1,\"brand\":\"MasterCard\",\"currency\":\"RUB\"}}";
        Transfer transfer = new Gson().fromJson(json, Transfer.class);
        System.out.println(transfer);
        Assert.assertNotNull(transfer.getTransferId());
        Assert.assertNotNull(transfer.getTransferDate());
        Assert.assertNotNull(transfer.getSum());
        Assert.assertNotNull(transfer.getCommissionId().getCommissionId());
        Assert.assertNotNull(transfer.getCommissionId().getBrand());
        Assert.assertNotNull(transfer.getCommissionId().getCurrency());*/
    }
}