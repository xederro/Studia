package pl.edu.pwr.student.lab02.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Person.
 */
public class Person {
    private int id;
    private PersonKind kind;
    private List<Ski> skis = new ArrayList<Ski>();

    /**
     * Instantiates a new Person.
     *
     * @param id   the id
     * @param kind the kind
     */
    public Person(int id, PersonKind kind) {
        this.id = id;
        this.kind = kind;
    }

    /**
     * Evaluate the result for given ski.
     *
     * @param ski the ski
     * @return the int
     */
    public int evaluate(Ski ski) {
        //no ski then penalty
        if (ski == null)
            return - Constants.getNoSkiPenalty();

        //calculating minimal penalty from preferences
        int minPenalty = Integer.MAX_VALUE;
        if (skis.get(0).type() != SkiType.noski){
            for (Ski s : skis) {
                int current = 0;
                //if ski length is 0 then length doesn't matter
                if (s.length() != 0){
                    //length difference * penalty
                    current = Constants.getSkiLenDiffPenalty() * Math.abs(ski.length() - s.length());
                }

                //other type than penalty1
                if (!Objects.equals(ski.type(), s.type()))
                    current += Constants.getSkiTypeDiffPenalty();

                //is better
                if (current < minPenalty) {
                    minPenalty = current;
                }
            }
        } else {
            //no ski preference so every ski is great
            minPenalty = 0;
        }

        return Constants.getSkiCost()*(100-Constants.getDiscounts().get(kind))/100 - minPenalty;
    }

    /**
     * Gets kind.
     *
     * @return the kind
     */
    public PersonKind getKind() {
        return kind;
    }

    /**
     * Add ski.
     *
     * @param ski the ski
     */
    public void addSki(Ski ski) {
        this.skis.add(ski);
    }

    /**
     * Add ski.
     *
     * @param ski the ski
     */
    public void addSki(Ski[] ski) {
        this.skis.addAll(List.of(ski));
    }

    /**
     * Add ski.
     *
     * @param ski the ski
     */
    public void addSki(List<Ski> ski) {
        this.skis.addAll(ski);
    }

    @Override
    public String toString() {
        return "\nPerson " + id;
    }
}
