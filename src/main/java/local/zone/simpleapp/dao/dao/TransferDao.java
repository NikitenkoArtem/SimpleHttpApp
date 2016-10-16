package local.zone.simpleapp.dao.dao;

import local.zone.simpleapp.dao.entity.Commission;
import local.zone.simpleapp.dao.entity.Transfer;
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
public class TransferDao extends AbstractGenericDaoImpl<Transfer, Integer> {
    public TransferDao(Connection connection, Class<Transfer> clazz) {
        super(connection, clazz);
    }

    @Override
    public Integer create(Transfer entity) {
        Map<Integer, Object> sqlParams = new HashMap<>();
        sqlParams.put(1, entity.getTransferDate());
        sqlParams.put(2, entity.getSum());
        sqlParams.put(3, entity.getCommissionId().getCommissionId());
        setSqlParams(sqlParams);
        setSql("INSERT INTO transfers(transfer_date, sum, commission_id) VALUES(?, ?, ?)");
        super.create(entity);
        return getNewPK();
    }

    @Override
    public Transfer read(Integer id) {
        setSql("SELECT * FROM transfers WHERE transfer_id = " + id);
        return super.read(id);
    }

    @Override
    public List<Transfer> readAll() {
        setSql("SELECT * FROM transfers");
        return super.readAll();
    }

    @Override
    protected void selectRow(ResultSet rs, Transfer entity) throws SQLException {
        entity.setTransferId(rs.getInt("transfer_id"));
        entity.setTransferDate(rs.getDate("transfer_date"));
        entity.setSum(rs.getDouble("sum"));
        Commission commission = new Commission();
        commission.setCommissionId(rs.getInt("commission_id"));
        entity.setCommissionId(commission);
    }
}
