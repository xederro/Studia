module frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires backend;

    exports pl.edu.pwr.student.djablonski.frontend;
    opens pl.edu.pwr.student.djablonski.frontend to javafx.fxml;
    exports pl.edu.pwr.student.djablonski.frontend.GUI;
    opens pl.edu.pwr.student.djablonski.frontend.GUI to javafx.fxml;
    exports pl.edu.pwr.student.djablonski.frontend.StationCell;
    opens pl.edu.pwr.student.djablonski.frontend.StationCell to javafx.fxml;
}