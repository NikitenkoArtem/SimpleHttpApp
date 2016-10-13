package local.zone.simpleapp.dao.dao;

import local.zone.simpleapp.dao.entity.Commission;
import local.zone.simpleapp.dao.generic.AbstractGenericDaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Price on 13.10.2016.
 */
public class CommissionDao extends AbstractGenericDaoImpl<Commission, Integer> {
    public CommissionDao(Connection connection, Class<Commission> clazz) {
        super(connection, clazz);
    }

    @Override
    protected void selectRow(ResultSet rs, Commission entity) throws SQLException {

    }
}
