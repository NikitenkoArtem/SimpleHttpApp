package local.zone.simpleapp.json.deserialize;

import com.google.gson.Gson;
import local.zone.simpleapp.dao.entity.Card;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Price on 15.10.2016.
 */
public class CardDeserializerTest {

    @Test
    public void deserialize() throws Exception {
        /*String json = "{\"cardId\":1,\"cardOwner\":{\"firstName\":\"Vasya\",\"lastName\":\"Pupkin\"}" +
//                ",\"cardExpire\":\"2016-10-17\"" +
                "}";
        Card card = new Gson().fromJson(json, Card.class);
        System.out.println(card);
        Assert.assertNotNull(card.getCardId());
        Assert.assertNotNull(card.getUserId().getFirstName());
        Assert.assertNotNull(card.getUserId().getLastName());
        Assert.assertNotNull(card.getExpirationDate());*/
    }
}