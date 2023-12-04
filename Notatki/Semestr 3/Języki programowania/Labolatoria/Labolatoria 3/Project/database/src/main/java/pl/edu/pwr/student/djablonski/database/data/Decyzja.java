package pl.edu.pwr.student.djablonski.database.data;

import pl.edu.pwr.student.djablonski.database.exceptions.DataParseException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Decyzja implements Queryable {
    private int id;
    private int id_zgloszenia;
    private int id_kierownika;
    private String opis;

    public Decyzja(int id, int id_zgloszenia, int id_kierownika, String opis) {
        this.id = id;
        this.id_zgloszenia = id_zgloszenia;
        this.id_kierownika = id_kierownika;
        this.opis = opis;
    }

    public Decyzja(ResultSet rs) throws DataParseException {
        try {
            this.id = rs.getInt("id");
            this.id_zgloszenia = rs.getInt("id_zgloszenia");
            this.id_kierownika = rs.getInt("id_kierownika");
            this.opis = rs.getString("opis");
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
        return "null ," + id_zgloszenia + " ," + id_kierownika + " ,'" + opis + "'";
    }

    @Override
    public String toString() {
        return "decyzja{" +
                "id=" + id +
                ", id_zgloszenia=" + id_zgloszenia +
                ", id_kierownika=" + id_kierownika +
                ", opis='" + opis + '\'' +
                '}';
    }

    public String getOpis() {
        return opis;
    }
}
