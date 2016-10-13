package local.zone.simpleapp.dao.dao;

import local.zone.simpleapp.dao.entity.Transfer;
import local.zone.simpleapp.dao.generic.AbstractGenericDaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Price on 13.10.2016.
 */
public class TransferDao extends AbstractGenericDaoImpl<Transfer, Integer> {
    public TransferDao(Connection connection, Class<Transfer> clazz) {
        super(connection, clazz);
    }

    @Override
    protected void selectRow(ResultSet rs, Transfer entity) throws SQLException {

    }
}
