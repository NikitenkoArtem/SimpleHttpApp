package local.zone.simpleapp.dao.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Price on 13.10.2016.
 */
public class Card implements Serializable {
    private Integer cardId;
    private User userId;
    private Date expirationDate;

    public Card() {
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", userId=" + userId +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
