package pl.edu.pwr.student.djablonski.database;

import pl.edu.pwr.student.djablonski.database.database.Database;
import pl.edu.pwr.student.djablonski.database.database.Migration;

public class Main {
    public static void main(String[] args) {
        try {
            Database.init();
            Migration.mocData(Database.DB);
            Database.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
