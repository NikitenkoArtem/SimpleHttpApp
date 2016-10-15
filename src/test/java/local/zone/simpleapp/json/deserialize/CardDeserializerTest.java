package local.zone.simpleapp.json.deserialize;

import com.google.gson.Gson;
import local.zone.simpleapp.dao.entity.Card;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Price on 15.10.2016.
 */
public class CardDeserializerTest {

    @Test
    public void deserialize() throws Exception {
        String json = "{\"cardId\":1,\"cardOwner\":{\"firstName\":\"Vasya\"},\"cardExpire\":\"2016-10-15\"}";
        Card card = new Gson().fromJson(json, Card.class);
        Assert.assertNotNull(card.getCardId());
        Assert.assertNotNull(card.getUserId().getFirstName());
        Assert.assertNotNull(card.getUserId().getLastName());
//        Assert.assertNotNull(card.getExpirationDate());
    }
}