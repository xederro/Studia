module backend {
    requires java.net.http;
    requires com.google.gson;
    exports pl.edu.pwr.student.djablonski.backend.Client;
    exports pl.edu.pwr.student.djablonski.backend.Data;
    exports pl.edu.pwr.student.djablonski.backend.Parser;
}