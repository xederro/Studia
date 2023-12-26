package pl.edu.pwr.student.djablonski.backend.Data;

import java.time.LocalDateTime;

//          "date":"2023-11-22 23:00:00",
//          "value":19.2884
public record Value(LocalDateTime date, Float value) {
}
