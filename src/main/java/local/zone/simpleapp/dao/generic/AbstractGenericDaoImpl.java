package local.zone.simpleapp.dao.generic;

import local.zone.simpleapp.util.Log;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Price on 30.09.2016.
 */
public abstract class AbstractGenericDaoImpl<E, PK> implements GenericDao<E, PK> {
    private Connection connection;
    private String sql;
    private Map<Integer, Object> sqlParams;
    private Class<E> clazz;
    private Logger logger = Log.getLogger(this.getClass());
    private Integer newPK;

    public AbstractGenericDaoImpl(Connection connection, Class<E> clazz) {
        this.connection = connection;
        this.clazz = clazz;
    }

    @Override
    public PK create(E entity) {
        try {
            newPK = executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    @Override
    public E read(PK id) {
        final E entity = getNewEntityInstance(clazz);
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        selectRow(rs, entity);
                    }
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return entity;
    }

    @Override
    public List<E> readAll() {
        ArrayList<E> list = new ArrayList<>();
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        final E entity = getNewEntityInstance(clazz);
                        selectRow(rs, entity);
                        list.add(entity);
                    }
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return list;
    }

    @Override
    public void update(E entity) {
        try {
            executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void delete(E entity) {

    }

    private Integer executeUpdate() throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            for (Map.Entry<Integer, Object> entry : sqlParams.entrySet()) {
                final int index = entry.getKey().intValue();
                final Object value = entry.getValue();
                if (value instanceof Integer) {
                    stmt.setInt(index, ((Integer) value).intValue());
                }
                if (value instanceof Date) {
                    stmt.setDate(index, (Date) value);
                }
                if (value instanceof String) {
                    stmt.setString(index, value.toString());
                }
                if (value instanceof Double) {
                    stmt.setDouble(index, ((Double) value).doubleValue());
                }
                if (value instanceof Float) {
                    stmt.setFloat(index, ((Float) value).floatValue());
                }
            }
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys != null && generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            return null;
        }
    }

    private E getNewEntityInstance(Class<E> entityClass) {
        E entity = null;
        try {
            entity = (E) entityClass.newInstance();
        } catch (InstantiationException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (IllegalAccessException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return entity;
    }

    protected String getSql() {
        return sql;
    }

    protected void setSql(String sql) {
        this.sql = sql;
    }

    protected Map<Integer, Object> getSqlParams() {
        return sqlParams;
    }

    protected void setSqlParams(Map<Integer, Object> sqlParams) {
        this.sqlParams = sqlParams;
    }

    protected Integer getNewPK() {
        return newPK;
    }

    protected abstract void selectRow(ResultSet rs, E entity) throws SQLException;
}
