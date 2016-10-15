package local.zone.simpleapp.dao.dao;

import local.zone.simpleapp.dao.entity.Card;
import local.zone.simpleapp.dao.entity.User;
import local.zone.simpleapp.dao.generic.AbstractGenericDaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Price on 13.10.2016.
 */
public class CardDao extends AbstractGenericDaoImpl<Card, Integer> {
    public CardDao(Connection connection, Class<Card> clazz) {
        super(connection, clazz);
    }

    @Override
    public Integer create(Card entity) {
        Map<Integer, Object> sqlParams = new HashMap<>();
        sqlParams.put(1, entity.getUserId().getUserId());
        sqlParams.put(2, entity.getExpirationDate());
        setSqlParams(sqlParams);
        setSql("INSER INTO cards(user_id, expiration_date) VALUES(?, ?)");
        return super.create(entity);
    }

    @Override
    public Card read(Integer id) {
        setSql("SELECT * FROM cards WHERE card_id" + id);
        return super.read(id);
    }

    @Override
    public List<Card> readAll() {
        setSql("SELECT * FROM cards");
        return super.readAll();
    }

    @Override
    protected void selectRow(ResultSet rs, Card entity) throws SQLException {
        entity.setCardId(rs.getInt("card_id"));
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        entity.setUserId(user);
        entity.setExpirationDate(rs.getDate("expiration_date"));
    }
}
