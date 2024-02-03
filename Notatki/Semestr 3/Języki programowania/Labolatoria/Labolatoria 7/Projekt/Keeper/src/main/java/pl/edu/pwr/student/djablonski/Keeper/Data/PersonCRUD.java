package pl.edu.pwr.student.djablonski.Keeper.Data;

import pl.edu.pwr.student.Common.Data.Person;

public interface PersonCRUD {
    Person getPerson(int key);
    void addPerson(int key, Person val);
    void delPerson(int key);
    void setPersonAvailability(int key, boolean ava);
}
