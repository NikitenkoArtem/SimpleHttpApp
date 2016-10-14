package local.zone.simpleapp.json.deserialize;

import com.google.gson.*;
import local.zone.simpleapp.dao.entity.Commission;
import local.zone.simpleapp.dao.entity.Currency;
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
        Date date = Date.valueOf(json.get("transferDate").getAsString());
        transfer.setTransferDate(date);
        transfer.setCurrencyId(context.deserialize(json.get("currencyId"), Currency.class));
        transfer.setSum(json.get("sum").getAsInt());
        transfer.setCommissionId(context.deserialize(json.get("commissionId"), Commission.class));
        return transfer;
    }
}
