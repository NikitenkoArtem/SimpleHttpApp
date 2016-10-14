package local.zone.simpleapp.json.serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import local.zone.simpleapp.dao.entity.User;

import java.lang.reflect.Type;

/**
 * Created by Price on 14.10.2016.
 */
public class UserSerializer implements JsonSerializer<User> {
    @Override
    public JsonElement serialize(User user, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();
        if (user != null) {
            json.addProperty("userId", user.getUserId());
            json.addProperty("firstName", user.getFirstName());
            json.addProperty("lastName", user.getLastName());
        }
        return json;
    }
}
