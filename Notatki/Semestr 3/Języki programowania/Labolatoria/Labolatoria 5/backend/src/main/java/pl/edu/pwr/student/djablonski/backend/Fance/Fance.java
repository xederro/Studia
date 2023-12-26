package pl.edu.pwr.student.djablonski.backend.Fance;

import pl.edu.pwr.student.djablonski.backend.Context.Context;
import pl.edu.pwr.student.djablonski.backend.State.State;

import java.util.ArrayList;

public class Fance {
    private final ArrayList<Section> Sections = new ArrayList<>();
    private final ArrayList<Plank> Planks = new ArrayList<>();
    private final State state;

    public Fance(State state) {
        this.state = state;
        for (int i = Context.CountOfSegments(); i > 0; i--) {
            Section s = new Section();
            Planks.addAll(s.getPlanks());
            Sections.add(s);
        }
    }

    public synchronized boolean isFinished(){
        for (Section s : Sections){
            if(!s.isFinished()){
                return false;
            }
        }
        return true;
    }

    public synchronized Plank next(Plank plank){
        if (isFinished()){
            state.stop();
            return null;
        }

        Plank p = Planks.get(getPlankIndex(plank));
        p.assign();
        return p;
    }

    private synchronized int getPlankIndex(Plank plank){
        if (plank != null) {
            int index = Planks.indexOf(plank);
            index++;
            if (index < Planks.size()){
                Plank p = Planks.get(index);
                if (!p.isAssigned() && !p.isPainted()){
                    return index;
                }
            }
        }

        int start = -1;
        int size = -1;
        for (int i = 0; i < Planks.size(); i++) {
            int tmpStart;
            if (!Planks.get(i).isAssigned()){
                tmpStart = i;
                while (true){
                    i++;
                    if (i >= Planks.size()){
                        if (i-tmpStart > size){
                            size = i-tmpStart;
                            start = tmpStart;
                        }
                        break;
                    } else if (Planks.get(i).isAssigned()){
                        if (i-1-tmpStart > size){
                            size = i-1-tmpStart;
                            start = tmpStart;
                        }
                        break;
                    }
                }
            }
        }
        if (size == Planks.size()) return 0;
        return (int) (start+Math.floor(size/2.0));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Section s : Sections){
            sb.append(s.toString());
        }
        sb.append("|");
        return sb.toString();
    }
}
