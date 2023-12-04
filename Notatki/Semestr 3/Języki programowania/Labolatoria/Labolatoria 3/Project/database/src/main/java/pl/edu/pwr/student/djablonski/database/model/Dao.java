package pl.edu.pwr.student.djablonski.database.model;

import pl.edu.pwr.student.djablonski.database.data.Queryable;
import pl.edu.pwr.student.djablonski.database.data.Status;
import pl.edu.pwr.student.djablonski.database.database.Database;
import pl.edu.pwr.student.djablonski.database.exceptions.DaoException;

import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dao<T extends Queryable> implements DaoInterface<T> {
    private String tableName = null;
    private Constructor<T> cons = null;

    public Dao(String tableName, Constructor<T> cons) {
        this.tableName = tableName;
        this.cons = cons;
    }

    @Override
    public List<T> readAll() throws DaoException {
        try {
            Database.init();
            Statement statement = Database.DB.createStatement();
            ResultSet result = statement.executeQuery("select * from " + tableName);
            List<T> temp = new ArrayList<>();
            while (result.next()){
                temp.add(
                        cons.newInstance(result)
                );
            }
            Database.close();
            return temp;
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public List<T> readAllBy(String filter, Object data) throws DaoException {
        try {
            Database.init();
            Statement statement = Database.DB.createStatement();
            String query = "select * from " + tableName + " WHERE "+ filter +" = ";
            if (data instanceof Integer){
                query+=data;
            } else if (data instanceof String) {
                query+=("'")+data+("'");
            } else if (data instanceof Status) {
                query+=("'")+data+("'");
            } else {
                query+=("'")+data+("'");
            }
            ResultSet result = statement.executeQuery(query);
            List<T> temp = new ArrayList<>();
            while (result.next()){
                temp.add(
                        cons.newInstance(result)
                );
            }
            Database.close();
            return temp;
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public T readOneByID(int ID) throws DaoException {
        try {
            Database.init();
            Statement statement = Database.DB.createStatement();
            ResultSet result = statement.executeQuery("select * from " + tableName + " WHERE id = " + ID + " limit 1");
            T temp = null;
            while (result.next()){
                temp = cons.newInstance(result);
            }
            Database.close();
            return temp;
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public int create(T entity) throws DaoException {
        try {
            Database.init();
            Statement statement = Database.DB.createStatement();
            statement.execute("insert into " + tableName + " values(" + entity.queryString() + ");");
            ResultSet rs = statement.executeQuery("SELECT last_insert_rowid();");
            int temp = rs.getInt("last_insert_rowid()");
            Database.close();
            return temp;
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Map<String, Object> changes, int ID) throws DaoException {
        try {
            Database.init();
            Statement statement = Database.DB.createStatement();
            StringBuilder query = new StringBuilder("update " + tableName + " set ");
            for (Map.Entry<String, Object> e : changes.entrySet()){
                query.append(e.getKey()).append("=");
                if (e.getValue() instanceof Integer){
                    query.append(e.getValue());
                } else if (e.getValue() instanceof String) {
                    query.append("'").append(e.getValue()).append("'");
                } else if (e.getValue() instanceof Status) {
                    query.append("'").append(e.getValue()).append("'");
                } else {
                    query.append("'").append(e.getValue()).append("'");
                }
                query.append(",");
            }
            query = new StringBuilder(query.substring(0, query.length() - 1));
            query.append(" where id = ").append(ID);
            statement.execute(query.toString());
            Database.close();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        try {
            Database.init();
            Statement statement = Database.DB.createStatement();
            statement.execute("delete from " + tableName + " where id = " + id);
            Database.close();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }
}
