package local.zone.simpleapp.dao.dao;

import local.zone.simpleapp.dao.entity.Currency;
import local.zone.simpleapp.dao.generic.AbstractGenericDaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Price on 13.10.2016.
 */
public class CurrencyDao extends AbstractGenericDaoImpl<Currency, Integer> {
    public CurrencyDao(Connection connection, Class<Currency> clazz) {
        super(connection, clazz);
    }

    @Override
    protected void selectRow(ResultSet rs, Currency entity) throws SQLException {

    }
}
