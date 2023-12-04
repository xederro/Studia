package pl.edu.pwr.student.djablonski.database.data;

import pl.edu.pwr.student.djablonski.database.context.Context;
import pl.edu.pwr.student.djablonski.database.exceptions.DaoException;
import pl.edu.pwr.student.djablonski.database.exceptions.DataParseException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Zgloszenie implements Queryable {
    private int id;
    private int id_obywatela;
    private List<Drzewo> lista_drzew;
    private Status status;
    private Date data_zgloszenia;
    private Integer id_kontrolera;

    public void addLista_drzew(Drzewo drzewo) {
        if (lista_drzew == null) {
            lista_drzew = new ArrayList<>();
        }
        lista_drzew.add(drzewo);
    }

    public Zgloszenie(int id, int idObywatela, List<Drzewo> listaDrzew, Status status, Date dataZgloszenia, Integer idKontrolera) {
        this.id = id;
        id_obywatela = idObywatela;
        id_kontrolera = idKontrolera;
        lista_drzew = listaDrzew;
        this.status = status;
        data_zgloszenia = dataZgloszenia;
    }

    public Zgloszenie(ResultSet rs) throws DataParseException {
        try {
            id = rs.getInt("id");
            id_obywatela = rs.getInt("id_obywatela");
            lista_drzew = null;
            status = Status.valueOf(rs.getString("status"));
            data_zgloszenia = new Date(rs.getLong("data_zgloszenia"));
            id_kontrolera = rs.getInt("id_kontrolera");
        } catch (SQLException e){
            throw new DataParseException(e);
        }
    }

    public void connTrees() {
        if (lista_drzew == null){
            try {
                lista_drzew = Context.daoDrzewo.readAllBy("id_zgloszenia", id);
            } catch (DaoException e){
                lista_drzew = null;
            }
        }
    }

    public List<Drzewo> getTrees() {
        connTrees();
        return lista_drzew;
    }

    public Object[] toTableRow() {
        return new Object[]{id, status, data_zgloszenia};
    }

    @Override
    public int id() {
        return id;
    }

    public void id(int id) {
        this.id = id;
    }

    @Override
    public String queryString() {
        return null + "," + id_obywatela + ",'" + status.toString() + "'," + data_zgloszenia.getTime() + "," + null;
    }

    @Override
    public String toString() {
        return "zgloszenie{" +
                "id=" + id +
                ", id_obywatela=" + id_obywatela +
                ", lista_drzew=" + lista_drzew +
                ", status=" + status +
                ", data_zgloszenia=" + data_zgloszenia +
                '}';
    }

    public Status getStatus() {
        return status;
    }
}
