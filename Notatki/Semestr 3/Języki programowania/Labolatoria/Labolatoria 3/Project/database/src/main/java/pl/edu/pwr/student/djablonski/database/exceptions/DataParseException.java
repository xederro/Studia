package pl.edu.pwr.student.djablonski.database.exceptions;

import java.sql.SQLException;

public class DataParseException extends SQLException {
    public DataParseException(Throwable cause) {
        super("There was error while parsing data from SQL", cause);
    }
}
