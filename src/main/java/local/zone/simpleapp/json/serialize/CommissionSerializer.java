package local.zone.simpleapp.json.serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import local.zone.simpleapp.dao.entity.Commission;
import local.zone.simpleapp.dao.entity.Currency;

import java.lang.reflect.Type;

/**
 * Created by Price on 14.10.2016.
 */
public class CommissionSerializer implements JsonSerializer<Commission> {
    @Override
    public JsonElement serialize(Commission commission, Type type, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        if (commission != null) {
            json.addProperty("commissionId", commission.getCommissionId());
            json.addProperty("brand", commission.getBrand());
            json.add("currencyId", context.serialize(commission.getCurrencyId(), Currency.class));
            json.addProperty("value", commission.getValue());
        }
        return json;
    }
}
