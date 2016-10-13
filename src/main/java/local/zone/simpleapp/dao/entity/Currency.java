package local.zone.simpleapp.dao.entity;

import java.io.Serializable;

/**
 * Created by Price on 13.10.2016.
 */
public class Currency implements Serializable {
    private Integer cardId;
    private String currency;

    public Currency() {
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "cardId=" + cardId +
                ", currency='" + currency + '\'' +
                '}';
    }
}
