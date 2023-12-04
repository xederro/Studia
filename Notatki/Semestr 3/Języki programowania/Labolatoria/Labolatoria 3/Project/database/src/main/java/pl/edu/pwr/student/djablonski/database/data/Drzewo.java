package pl.edu.pwr.student.djablonski.database.data;

import pl.edu.pwr.student.djablonski.database.exceptions.DataParseException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Drzewo implements Queryable {
    private int id;
    private String nazwa;
    private int srednica;
    private int id_zgloszenia;

    public Drzewo(int id, String nazwa, int srednica, int id_zgloszenia) {
        this.id = id;
        this.nazwa = nazwa;
        this.srednica = srednica;
        this.id_zgloszenia = id_zgloszenia;
    }

    public Drzewo(ResultSet rs) throws DataParseException {
        try{
            this.id = rs.getInt("id");
            this.nazwa = rs.getString("nazwa");
            this.srednica = rs.getInt("srednica");
            this.id_zgloszenia = rs.getInt("id_zgloszenia");
        } catch (SQLException e){
            throw new DataParseException(e);
        }
    }

    public Object[] toTableRow() {
        return new Object[]{nazwa, srednica};
    }

    @Override
    public String toString() {
        return nazwa + "-" + srednica + "cm\n";
    }

    @Override
    public int id() {
        return id;
    }

    public void id(int i) {
        id = i;
    }

    @Override
    public String queryString() {
        return "null ,'" + nazwa + "' ," + srednica + "," + id_zgloszenia;
    }
}
