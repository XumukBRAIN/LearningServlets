package dao;

import model.Brand;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T, ID> {
    Optional<T> find(String id) throws SQLException, ClassNotFoundException;
    List<T> findAll() throws SQLException, ClassNotFoundException;
    boolean save(Brand o) throws SQLException;
    boolean update(Brand o) throws SQLException;
    boolean delete(Brand o) throws SQLException;
}
