package pl.edu.pwr.student.lab02.tactics;

import pl.edu.pwr.student.lab02.data.Variation;

/**
 * Abstract class for methods.
 */
public abstract class AbstractMethod implements MethodInterface {
    /**
     * Holds the best result
     */
    protected Integer best = Integer.MIN_VALUE;
    /**
     * Holds the best variation
     */
    protected Variation bestV;

    /**
     * Runs Method
     */
    @Override
    public abstract void find();

    @Override
    public String toString() {
        return "Best:" + best + "\nFor: " + bestV;
    }
}
