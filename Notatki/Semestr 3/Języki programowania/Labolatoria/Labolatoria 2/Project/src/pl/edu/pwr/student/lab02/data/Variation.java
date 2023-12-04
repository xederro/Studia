package pl.edu.pwr.student.lab02.data;

import java.util.*;

/**
 * The type Variation.
 */
public class Variation {
    private final Map<Person, Ski> peopleWithSkis;

    /**
     * Instantiates a new Variation.
     *
     * @param peopleWithSkis the people with skis
     */
    public Variation(Map<Person, Ski> peopleWithSkis) {
        this.peopleWithSkis = peopleWithSkis;
    }

    /**
     * Evaluate the result of given variation.
     *
     * @return the integer
     */
    public Integer evaluate(){
        int sum = 0;
        for (Person person : Constants.getPeople()) {
            sum += person.evaluate(peopleWithSkis.get(person));
        }
        return sum;
    }

    @Override
    public String toString() {
        return peopleWithSkis.toString();
    }
}
