package pl.edu.pwr.student.djablonski.backend.Fance;

public class Plank {
    private boolean painted = false;
    private boolean assigned = false;
    private String symbol = ".";

    public boolean isPainted() {
        return painted;
    }
    public boolean isAssigned() {
        return assigned;
    }
    public void assign() {
        assigned = true;
    }

    public void paint(String symbol) {
        this.painted = true;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
