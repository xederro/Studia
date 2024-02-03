package pl.edu.pwr.student.djablonski.Keeper.Data;

import pl.edu.pwr.student.Common.Data.Person;
import pl.edu.pwr.student.Common.Enums.Role;

import java.util.HashMap;
import java.util.Map;

public class Persons implements PersonCRUD {
    private final Map<Integer, Person> persons = new HashMap<>();

    public synchronized Person getPerson(int key) {
        if (key == 0){
            for (Map.Entry<Integer, Person> e : persons.entrySet()) {
                if (e.getValue().role == Role.Seller && e.getValue().isAvailable()) {
                    e.getValue().setAvailable(false);
                    return e.getValue();
                }
            }
        }

        return persons.get(key);
    }

    public synchronized void addPerson(int key, Person val) {
        persons.put(key, val);
    }

    public synchronized void delPerson(int key) {
        persons.remove(key);
    }

    public synchronized void setPersonAvailability(int key, boolean ava) {
        persons.get(key).setAvailable(ava);
    }
}
