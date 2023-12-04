package pl.edu.pwr.student.lab02.reader;

import java.io.IOException;

public class EmptyFileException extends IOException {
    public EmptyFileException(String file){
        super(file + " is empty");
    }
}
