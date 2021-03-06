package local.zone.simpleapp.json.deserialize;

import com.google.gson.*;
import local.zone.simpleapp.dao.entity.Commission;
import local.zone.simpleapp.dao.entity.Transfer;

import java.lang.reflect.Type;
import java.sql.Date;

/**
 * Created by Price on 14.10.2016.
 */
public class TransferDeserializer implements JsonDeserializer<Transfer> {
    @Override
    public Transfer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject json = jsonElement.getAsJsonObject();
        Transfer transfer = new Transfer();
        transfer.setTransferId(json.get("transferId").getAsInt());
        String transferDate = json.get("transferDate").getAsString();
        transfer.setTransferDate(Date.valueOf(transferDate));
        transfer.setSum(json.get("sum").getAsDouble());
        transfer.setCommissionId(context.deserialize(json.get("commissionId"), Commission.class));
        return transfer;
    }
}
