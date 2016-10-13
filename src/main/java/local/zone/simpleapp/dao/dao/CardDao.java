package local.zone.simpleapp.dao.dao;

import local.zone.simpleapp.dao.generic.AbstractGenericDaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Price on 13.10.2016.
 */
public class CardDao extends AbstractGenericDaoImpl<Card, Integer> {
    public CardDao(Connection connection, Class<Card> clazz) {
        super(connection, clazz);
    }

    @Override
    protected void selectRow(ResultSet rs, Card entity) throws SQLException {

    }
}
