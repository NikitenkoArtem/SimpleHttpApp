package local.zone.simpleapp.json.serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import local.zone.simpleapp.dao.entity.Card;
import local.zone.simpleapp.dao.entity.User;

import java.lang.reflect.Type;

/**
 * Created by Price on 14.10.2016.
 */
public class CardSerializer implements JsonSerializer<Card> {
    @Override
    public JsonElement serialize(Card card, Type type, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        if (card != null) {
            json.addProperty("cardId", card.getCardId());
            json.add("cardOwner", context.serialize(card.getUserId(), User.class));
            json.addProperty("cardExpire", String.valueOf(card.getExpirationDate()));
        }
        return json;
    }
}
