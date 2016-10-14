package local.zone.simpleapp.dao.dao;

import local.zone.simpleapp.dao.entity.Card;
import local.zone.simpleapp.dao.generic.AbstractGenericDaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Price on 13.10.2016.
 */
public class CardDao extends AbstractGenericDaoImpl<Card, Integer> {
    public CardDao(Connection connection, Class<Card> clazz) {
        super(connection, clazz);
    }

    @Override
    public Integer create(Card entity) {
        return super.create(entity);
    }

    @Override
    public Card read(Integer id) {
        return super.read(id);
    }

    @Override
    public List<Card> readAll() {
        return super.readAll();
    }

    @Override
    protected void selectRow(ResultSet rs, Card entity) throws SQLException {

    }
}
