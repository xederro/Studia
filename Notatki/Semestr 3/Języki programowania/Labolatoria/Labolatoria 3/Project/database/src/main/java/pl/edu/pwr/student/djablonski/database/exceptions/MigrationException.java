package pl.edu.pwr.student.djablonski.database.exceptions;

import java.sql.SQLException;

public class MigrationException extends SQLException {
    public MigrationException(Throwable cause) {
        super("There was error while migrating data to the Database", cause);
    }
}
