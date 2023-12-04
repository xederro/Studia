package pl.edu.pwr.student.djablonski.database.exceptions;

import java.sql.SQLException;

public class DatabaseCreatingException extends SQLException {
    public DatabaseCreatingException(Throwable cause) {
        super("There was error while creating the Database", cause);
    }
}
