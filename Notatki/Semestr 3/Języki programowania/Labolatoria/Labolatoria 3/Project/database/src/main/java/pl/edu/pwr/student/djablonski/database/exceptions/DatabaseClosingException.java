package pl.edu.pwr.student.djablonski.database.exceptions;

import java.sql.SQLException;

public class DatabaseClosingException extends SQLException {
    public DatabaseClosingException(Throwable cause) {
        super("There was error while closing the Database", cause);
    }
}
