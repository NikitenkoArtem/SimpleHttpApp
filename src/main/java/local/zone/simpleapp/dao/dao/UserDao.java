package local.zone.simpleapp.dao.dao;

import local.zone.simpleapp.dao.entity.User;
import local.zone.simpleapp.dao.generic.AbstractGenericDaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Price on 13.10.2016.
 */
public class UserDao extends AbstractGenericDaoImpl<User, Integer> {
    public UserDao(Connection connection, Class<User> clazz) {
        super(connection, clazz);
    }

    @Override
    public Integer create(User entity) {
        return super.create(entity);
    }

    @Override
    public User read(Integer id) {
        return super.read(id);
    }

    @Override
    public List<User> readAll() {
        return super.readAll();
    }

    @Override
    public void update(User entity) {
        super.update(entity);
    }

    @Override
    protected void selectRow(ResultSet rs, User entity) throws SQLException {

    }
}
