package pl.edu.pwr.student.djablonski.database.data;


import pl.edu.pwr.student.djablonski.database.exceptions.DataParseException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Obywatel implements Queryable {
    private int id;
    private String nazwa;

    public Obywatel(int id, String nazwa){
        this.id = id;
        this.nazwa = nazwa;
    }
    public Obywatel(ResultSet rs) throws DataParseException {
        try {
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
        return "obywatel{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
