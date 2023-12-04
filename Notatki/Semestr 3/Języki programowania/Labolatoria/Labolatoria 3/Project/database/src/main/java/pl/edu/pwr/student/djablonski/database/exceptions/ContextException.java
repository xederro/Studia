package pl.edu.pwr.student.djablonski.database.exceptions;

public class ContextException extends RuntimeException{
    public ContextException(Throwable cause) {
        super("There was error while creating the Context", cause);
    }
}
