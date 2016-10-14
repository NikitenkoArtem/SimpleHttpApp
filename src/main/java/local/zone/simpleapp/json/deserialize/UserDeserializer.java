package local.zone.simpleapp.json.deserialize;

import com.google.gson.*;
import local.zone.simpleapp.dao.entity.User;

import java.lang.reflect.Type;

/**
 * Created by Price on 14.10.2016.
 */
public class UserDeserializer implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject json = jsonElement.getAsJsonObject();
        User user = new User();
        user.setUserId(json.get("userId").getAsInt());
        user.setFirstName(json.get("firstName").getAsString());
        user.setLastName(json.get("lastName").getAsString());
        return user;
    }
}
