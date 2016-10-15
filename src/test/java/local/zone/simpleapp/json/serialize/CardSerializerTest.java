package local.zone.simpleapp.json.serialize;

import com.google.gson.*;
import local.zone.simpleapp.dao.entity.Card;
import local.zone.simpleapp.dao.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

/**
 * Created by Price on 15.10.2016.
 */
public class CardSerializerTest {

    @Test
    public void serialize() throws Exception {
        Card card = new Card();
        card.setCardId(1);
        User user = new User();
        user.setFirstName("Vasya");
        card.setUserId(user);
        card.setExpirationDate(new Date(System.currentTimeMillis()));
        Gson gson = new GsonBuilder().registerTypeAdapter(Card.class, new CardSerializer()).create();
        String json = gson.toJson(card);
        System.out.println(json);
        Assert.assertNotNull(gson);
        Assert.assertNotNull(json);
        Assert.assertNotEquals("", json);
    }
}