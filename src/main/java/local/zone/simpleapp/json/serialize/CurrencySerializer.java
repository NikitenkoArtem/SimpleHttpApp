package local.zone.simpleapp.json.serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import local.zone.simpleapp.dao.entity.Currency;

import java.lang.reflect.Type;

/**
 * Created by Price on 14.10.2016.
 */
public class CurrencySerializer implements JsonSerializer<Currency> {
    @Override
    public JsonElement serialize(Currency currency, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();
        if (currency != null) {
            json.addProperty("currencyId", currency.getCurrencyId());
            json.addProperty("currency", currency.getCurrency());
        }
        return json;
    }
}
