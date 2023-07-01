package org.example;

import java.time.LocalDate;
import java.util.Date;

public class DataPrzydatnosci {
    private LocalDate date;

    public DataPrzydatnosci(String date) {
        this.date = LocalDate.parse(date);
    }

    public LocalDate getDate() {
        return date;
    }
}
