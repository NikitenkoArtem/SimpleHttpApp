package local.zone.simpleapp.json.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import local.zone.simpleapp.dao.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Price on 15.10.2016.
 */
public class UserSerializerTest {

    @Test
    public void serialize() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setFirstName("Vasya");
        user.setLastName("Pupkin");
        Gson gson = new GsonBuilder().registerTypeAdapter(User.class, new UserSerializer()).create();
        String json = gson.toJson(user);
        System.out.println(json);
        Assert.assertNotNull(gson);
        Assert.assertNotNull(json);
        Assert.assertNotEquals("", json);
    }
}