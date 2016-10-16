package local.zone.simpleapp.json.deserialize;

import com.google.gson.*;
import local.zone.simpleapp.dao.entity.Commission;

import java.lang.reflect.Type;

/**
 * Created by Price on 14.10.2016.
 */
public class CommissionDeserializer implements JsonDeserializer<Commission> {
    @Override
    public Commission deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject json = jsonElement.getAsJsonObject();
        Commission commission = new Commission();
        commission.setCommissionId(json.get("commissionId").getAsInt());
        commission.setBrand(json.get("brand").getAsString());
        commission.setCurrency(json.get("currency").getAsString());
        commission.setValue(json.get("value").getAsFloat());
        return commission;
    }
}
