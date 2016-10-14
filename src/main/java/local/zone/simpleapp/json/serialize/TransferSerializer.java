package local.zone.simpleapp.json.serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import local.zone.simpleapp.dao.entity.Commission;
import local.zone.simpleapp.dao.entity.Currency;
import local.zone.simpleapp.dao.entity.Transfer;

import java.lang.reflect.Type;

/**
 * Created by Price on 14.10.2016.
 */
public class TransferSerializer implements JsonSerializer<Transfer> {
    @Override
    public JsonElement serialize(Transfer transfer, Type type, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        if (transfer != null) {
            json.addProperty("transferId", transfer.getTransferId());
            json.addProperty("transferDate", String.valueOf(transfer.getTransferDate()));
            json.add("currencyId", context.serialize(transfer.getCurrencyId(), Currency.class));
            json.addProperty("sum", transfer.getSum());
            json.add("commissionId", context.serialize(transfer.getCommissionId(), Commission.class));
        }
        return json;
    }
}
