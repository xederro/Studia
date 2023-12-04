package pl.edu.pwr.student.djablonski.database.database;

import pl.edu.pwr.student.djablonski.database.exceptions.DatabaseClosingException;
import pl.edu.pwr.student.djablonski.database.exceptions.DatabaseCreatingException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Database {
    public static Connection DB = null;
    public static void init() throws DatabaseCreatingException {
        if (DB == null){
            try {
                DB = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
                ResultSet rs = DB.createStatement().executeQuery("select count(*) from sqlite_master where type ='table';");
                if(rs.getInt("count(*)") < 8) Migration.migrate(DB);
            } catch (SQLException e){
                throw new DatabaseCreatingException(e);
            }
        }
    }

    public static void close() throws DatabaseClosingException {
        try {
            DB.close();
            DB = null;
        } catch (SQLException e) {
            throw new DatabaseClosingException(e);
        }
    }
}
