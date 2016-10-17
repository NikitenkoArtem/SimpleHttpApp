package local.zone.simpleapp.json.deserialize;

import com.google.gson.Gson;
import local.zone.simpleapp.dao.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Price on 15.10.2016.
 */
public class UserDeserializerTest {

    @Test
    public void deserialize() throws Exception {
        String json = "{\"userId\":1,\"firstName\":\"Vasya\",\"lastName\":\"Pupkin\"}";
        User user = new Gson().fromJson(json, User.class);
        System.out.println(user);
        Assert.assertNotNull(user.getUserId());
        Assert.assertNotNull(user.getFirstName());
        Assert.assertNotNull(user.getLastName());
    }
}