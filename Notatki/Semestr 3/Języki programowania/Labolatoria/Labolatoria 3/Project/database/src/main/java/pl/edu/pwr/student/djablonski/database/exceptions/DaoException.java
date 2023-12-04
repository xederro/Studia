package pl.edu.pwr.student.djablonski.database.exceptions;

import java.sql.SQLException;

public class DaoException extends SQLException {
    public DaoException(Throwable cause) {
        super("There was error while using Dao method", cause);
    }
}
