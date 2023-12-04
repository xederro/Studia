package pl.edu.pwr.student.lab02.data;

/**
 * The record Ski.
 */
public record Ski(int length, SkiType type) {
    @Override
    public String toString() {
        return "length=" + length + ", type='" + type + '\'';
    }
}
