package pl.edu.pwr.student.lab02.tactics;

import pl.edu.pwr.student.lab02.data.Constants;
import pl.edu.pwr.student.lab02.data.Person;
import pl.edu.pwr.student.lab02.data.Ski;
import pl.edu.pwr.student.lab02.data.Variation;

import java.util.*;

/**
 * The type Random method.
 */
public class RandomMethod extends AbstractMethod {
    private final Random random = new Random();

    /**
     * Instantiates a new Random method.
     */
    public RandomMethod() {}

    /**
     * Runs Method
     */
    public void find() {
        //checks 1 million random variations
        for (int i = 0; i < 1000000; i++) {
            //Initializes lists of possible skis and people and map for assignments
            Map<Person, Ski> peopleWithSkis = new HashMap<>();
            List<Person> possiblePeople = new ArrayList<>(Constants.getPeople());
            List<Ski> possibleSkis = new ArrayList<>();

            for (Map.Entry<Ski, Integer> entry : Constants.getAssortment().entrySet()) {
                for (int j = 0; j < entry.getValue(); j++) {
                    possibleSkis.add(entry.getKey());
                }
            }

            //for select randomly person and then select randomly ski then assign
            for (int j = possiblePeople.size(); j > 0; j--) {
                Person person = possiblePeople.get(random.nextInt(j));
                possiblePeople.remove(person);

                if (possibleSkis.isEmpty()){
                    peopleWithSkis.put(person, null);
                    continue;
                }

                Ski randomSki = possibleSkis.get(random.nextInt(possibleSkis.size()));
                possibleSkis.remove(randomSki);

                peopleWithSkis.put(person, randomSki);
            }

            //Check if variation is better than saved one
            Variation variation = new Variation(peopleWithSkis);
            Integer current = variation.evaluate();
            if (current > best) {
                best = current;
                bestV = variation;
            }
        }
    }
}
