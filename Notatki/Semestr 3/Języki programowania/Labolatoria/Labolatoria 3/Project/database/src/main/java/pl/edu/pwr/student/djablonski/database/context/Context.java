package pl.edu.pwr.student.djablonski.database.context;

import pl.edu.pwr.student.djablonski.database.data.*;
import pl.edu.pwr.student.djablonski.database.exceptions.ContextException;
import pl.edu.pwr.student.djablonski.database.model.Dao;

import java.sql.ResultSet;

public abstract class Context {
    public static final Dao<Zgloszenie> daoZgloszenie;
    public static final Dao<Kontroler> daoKontroler;
    public static final Dao<Drzewo> daoDrzewo;
    public static final Dao<Decyzja> daoDecyzja;
    public static final Dao<Raport> daoRaport;
    public static final Dao<Kierownik> daoKierownik;
    public static final Dao<Obywatel> daoObywatel;

    static {
        try {
            daoZgloszenie = new Dao<Zgloszenie>("zgloszenie", Zgloszenie.class.getConstructor(ResultSet.class));
            daoKontroler = new Dao<Kontroler>("kontroler", Kontroler.class.getConstructor(ResultSet.class));
            daoDrzewo = new Dao<Drzewo>("drzewo", Drzewo.class.getConstructor(ResultSet.class));
            daoRaport = new Dao<Raport>("raport", Raport.class.getConstructor(ResultSet.class));
            daoDecyzja = new Dao<Decyzja>("decyzja", Decyzja.class.getConstructor(ResultSet.class));
            daoKierownik = new Dao<Kierownik>("kierownik", Kierownik.class.getConstructor(ResultSet.class));
            daoObywatel = new Dao<Obywatel>("obywatel", Obywatel.class.getConstructor(ResultSet.class));
        } catch (NoSuchMethodException e) {
            throw new ContextException(e);
        }
    }
}
