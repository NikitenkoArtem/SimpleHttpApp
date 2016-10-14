package local.zone.simpleapp.json.deserialize;

import com.google.gson.*;
import local.zone.simpleapp.dao.entity.Card;
import local.zone.simpleapp.dao.entity.User;

import java.lang.reflect.Type;
import java.sql.Date;

/**
 * Created by Price on 14.10.2016.
 */
public class CardDeserializer implements JsonDeserializer<Card> {
    @Override
    public Card deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject json = jsonElement.getAsJsonObject();
        Card card = new Card();
        card.setCardId(json.get("cardId").getAsInt());
        card.setUserId(context.deserialize(json.get("cardOwner"), User.class));
        Date date = Date.valueOf(json.get("cardExpire").getAsString());
        card.setExpirationDate(date);
        return card;
    }
}
