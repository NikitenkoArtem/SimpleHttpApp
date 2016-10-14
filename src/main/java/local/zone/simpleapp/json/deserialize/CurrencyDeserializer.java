package local.zone.simpleapp.json.deserialize;

import com.google.gson.*;
import local.zone.simpleapp.dao.entity.Currency;

import java.lang.reflect.Type;

/**
 * Created by Price on 14.10.2016.
 */
public class CurrencyDeserializer implements JsonDeserializer<Currency> {
    @Override
    public Currency deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject json = jsonElement.getAsJsonObject();
        Currency currency = new Currency();
        currency.setCurrencyId(json.get("currencyId").getAsInt());
        currency.setCurrency(json.get("currency").getAsString());
        return currency;
    }
}
