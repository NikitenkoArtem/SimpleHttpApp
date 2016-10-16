package local.zone.simpleapp.dao.dao;

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
public class UserDao extends AbstractGenericDaoImpl<User, Integer> {
    public UserDao(Connection connection, Class<User> clazz) {
        super(connection, clazz);
    }

    @Override
    public Integer create(User entity) {
        Map<Integer, Object> sqlParams = new HashMap<>();
        sqlParams.put(1, entity.getFirstName());
        sqlParams.put(2, entity.getLastName());
        super.setSqlParams(sqlParams);
        setSql("INSERT INTO users(first_name, last_name) VALUES(?, ?)");
        super.create(entity);
        return getNewPK();
    }

    @Override
    public User read(Integer id) {
        setSql("SELECT * FROM users WHERE user_id = " + id);
        return super.read(id);
    }

    @Override
    public List<User> readAll() {
        setSql("SELECT * FROM users");
        return super.readAll();
    }

    @Override
    protected void selectRow(ResultSet rs, User entity) throws SQLException {
        entity.setUserId(rs.getInt("user_id"));
        entity.setFirstName(rs.getString("first_name"));
        entity.setLastName(rs.getString("last_name"));
    }
}
