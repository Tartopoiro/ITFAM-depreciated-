package com.accountx.modele.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

        public T findBy(String critere) throws SQLException;
        public List<T> findAll() throws SQLException;
        public boolean insert(T obj) throws SQLException;
        public boolean update(T obj) throws SQLException;
        public boolean delete(T obj) throws SQLException;

}
