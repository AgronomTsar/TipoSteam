package com.steamnonesteam.service;
import com.j256.ormlite.dao.Dao;
import com.steamnonesteam.model.Model;
import java.sql.SQLException;
import java.util.List;
public interface Service<T extends Model>{
    Dao<T,Integer> dao();
    default List<T> findAll() throws SQLException {
        return dao().queryForAll();
    }
    default T findById(int id) throws SQLException {
        return dao().queryForId(id);
    }
    default List<T> findBy(String columnName, Object value) throws SQLException {
        return dao().queryForEq(columnName, value);
    }
    default void save(T model) throws SQLException {
        dao().create(model);
    }
    default void update(T model) throws SQLException {
        dao().update(model);
    }
    default void delete (T model) throws SQLException {
        dao().delete(model);
    }

}
