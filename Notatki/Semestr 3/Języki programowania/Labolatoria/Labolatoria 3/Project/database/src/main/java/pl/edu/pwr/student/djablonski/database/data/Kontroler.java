package pl.edu.pwr.student.djablonski.database.data;

import pl.edu.pwr.student.djablonski.database.exceptions.DataParseException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Kontroler implements Queryable {
    private int id;
    private String nazwa;

    public Kontroler(int id, String nazwa){
        this.id = id;
        this.nazwa = nazwa;
    }
    public Kontroler(ResultSet rs) throws DataParseException {
        try{
            this.id = rs.getInt("id");
            this.nazwa = rs.getString("nazwa");
        } catch (SQLException e){
            throw new DataParseException(e);
        }
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public String queryString() {
        return "null ,'" + nazwa + "'";
    }

    @Override
    public String toString() {
        return "kontroler{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }

    public Object[] toTableRow() {
        return new Object[]{id, nazwa};
    }
}
