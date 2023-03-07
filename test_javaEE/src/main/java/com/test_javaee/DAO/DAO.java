package com.test_javaee.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T> {

        public T findById(int id) throws SQLException;
        public List<T> findAll() throws SQLException;
        public boolean insert(T obj) throws SQLException;
        public boolean update(T obj) throws SQLException;
        public boolean delete(T obj) throws SQLException;

}
