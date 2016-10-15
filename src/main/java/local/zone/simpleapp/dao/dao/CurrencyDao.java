package local.zone.simpleapp.dao.dao;

import local.zone.simpleapp.dao.entity.Currency;
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
public class CurrencyDao extends AbstractGenericDaoImpl<Currency, Integer> {
    public CurrencyDao(Connection connection, Class<Currency> clazz) {
        super(connection, clazz);
    }

    @Override
    public Integer create(Currency entity) {
        Map<Integer, Object> sqlParam = new HashMap<>();
        sqlParam.put(1, entity.getCurrency());
        setSqlParams(sqlParam);
        setSql("INSERT INTO currencies(currency) VALUES(?)");
        return super.create(entity);
    }

    @Override
    public Currency read(Integer id) {
        setSql("SELECT * FROM currencies WHERE currency_id = " + id);
        return super.read(id);
    }

    @Override
    public List<Currency> readAll() {
        setSql("SELECT * FROM currencies");
        return super.readAll();
    }

    @Override
    protected void selectRow(ResultSet rs, Currency entity) throws SQLException {
        entity.setCurrencyId(rs.getInt("currency_id"));
        entity.setCurrency(rs.getString("currency"));
    }
}
