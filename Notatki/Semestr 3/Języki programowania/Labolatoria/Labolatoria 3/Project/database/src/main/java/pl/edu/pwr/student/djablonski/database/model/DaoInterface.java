package pl.edu.pwr.student.djablonski.database.model;

import pl.edu.pwr.student.djablonski.database.exceptions.DaoException;

import java.util.List;
import java.util.Map;

public interface DaoInterface<T> {
    public List<T> readAll() throws DaoException;
    public List<T> readAllBy(String filter, Object data) throws DaoException;
    public T readOneByID(int ID) throws DaoException;
    public int create(T entity) throws DaoException;
    public void update(Map<String, Object> changes, int ID) throws DaoException;
    public void delete(int id) throws DaoException;
}
