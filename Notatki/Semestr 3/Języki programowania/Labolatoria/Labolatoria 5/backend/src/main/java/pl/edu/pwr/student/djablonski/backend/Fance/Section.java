package pl.edu.pwr.student.djablonski.backend.Fance;

import pl.edu.pwr.student.djablonski.backend.Context.Context;

import java.util.ArrayList;

public class Section {
    private final ArrayList<Plank> Planks = new ArrayList<>();


    public Section() {
        for (int i = Context.CountOfSegments(); i > 0; i--) {
            Planks.add(new Plank());
        }
    }

    public synchronized boolean isFinished(){
        for (Plank plank : Planks) {
            if (!plank.isPainted()) {
                return false;
            }
        }
        return true;
    }


    public ArrayList<Plank> getPlanks() {
        return Planks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (Plank s : Planks){
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
