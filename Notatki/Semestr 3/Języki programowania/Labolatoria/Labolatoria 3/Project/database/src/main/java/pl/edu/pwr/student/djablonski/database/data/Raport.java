package pl.edu.pwr.student.djablonski.database.data;

import pl.edu.pwr.student.djablonski.database.exceptions.DataParseException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Raport implements Queryable {
    private int id;
    private int id_zgloszenia;

    private String opis;

    public Raport(int id, int id_zgloszenia, String opis) {
        this.id = id;
        this.id_zgloszenia = id_zgloszenia;
        this.opis = opis;
    }

    public Raport(ResultSet rs) throws DataParseException {
        try{
            id = rs.getInt("id");
            id_zgloszenia = rs.getInt("id_zgloszenia");
            opis = rs.getString("opis");
        } catch (SQLException e){
            throw new DataParseException(e);
        }
    }

    public String getOpis() {
        return opis;
    }

    @Override
    public String toString() {
        return "raport{" +
                "id=" + id +
                ", id_zgloszenia=" + id_zgloszenia +
                ", opis='" + opis + '\'' +
                '}';
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public String queryString() {
        return "null ," + id_zgloszenia + ",'" + opis + "'";
    }

    public int getId_zgloszenia() {
        return id_zgloszenia;
    }
}
