package pl.edu.pwr.student.djablonski.frontend;

import pl.edu.pwr.student.djablonski.backend.Client.Client;
import pl.edu.pwr.student.djablonski.backend.Client.IClient;
import pl.edu.pwr.student.djablonski.backend.Parser.Parser;
import pl.edu.pwr.student.djablonski.frontend.GUI.StationsList;

public class Main {
    public static final IClient client = new Client(new Parser());
    public static void main(final String[] args) {
        StationsList.main(args);
    }
}
