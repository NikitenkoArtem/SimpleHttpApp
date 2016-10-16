package local.zone.simpleapp.dao.dao;

import local.zone.simpleapp.dao.entity.Commission;
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
public class CommissionDao extends AbstractGenericDaoImpl<Commission, Integer> {
    public CommissionDao(Connection connection, Class<Commission> clazz) {
        super(connection, clazz);
    }

    @Override
    public Integer create(Commission entity) {
        Map<Integer, Object> sqlParams = new HashMap<>();
        sqlParams.put(1, entity.getCommissionId());
        sqlParams.put(2, entity.getBrand());
        sqlParams.put(3, entity.getCurrency());
        sqlParams.put(4, entity.getValue());
        setSqlParams(sqlParams);
        setSql("INSERT INTO commissions(commission_id, brand, currency, value) VALUES(?, ?, ?, ?)");
        super.create(entity);
        return getNewPK();
    }

    @Override
    public Commission read(Integer id) {
        setSql("SELECT * FROM commissions WHERE commission_id = " + id);
        return super.read(id);
    }

    @Override
    public List<Commission> readAll() {
        setSql("SELECT * FROM commissions");
        return super.readAll();
    }

    @Override
    protected void selectRow(ResultSet rs, Commission entity) throws SQLException {
        entity.setCommissionId(rs.getInt("commission_id"));
        entity.setBrand(rs.getString("brand"));
        entity.setCurrency(rs.getString("currency"));
        entity.setValue(rs.getFloat("value"));
    }

    public Commission readByCurrency(String currency) {
        setSql("SELECT * FROM commissions WHERE currency = '" + currency + "'");
        return super.read(null);
    }
}
