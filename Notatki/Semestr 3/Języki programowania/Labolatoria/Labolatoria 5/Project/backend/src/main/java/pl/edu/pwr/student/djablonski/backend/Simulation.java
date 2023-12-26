package pl.edu.pwr.student.djablonski.backend;

import pl.edu.pwr.student.djablonski.backend.Context.Context;
import pl.edu.pwr.student.djablonski.backend.Fance.Fance;
import pl.edu.pwr.student.djablonski.backend.Paint.PaintContainer;
import pl.edu.pwr.student.djablonski.backend.Printer.Printer;
import pl.edu.pwr.student.djablonski.backend.State.State;
import pl.edu.pwr.student.djablonski.backend.Workers.PaintProducer;
import pl.edu.pwr.student.djablonski.backend.Workers.Painter;

import java.util.ArrayList;

public class Simulation {
    private final Fance fance;
    private final ArrayList<Painter> p;
    private final PaintContainer pc;
    private final PaintProducer pp;
    public final State state;

    public Fance getFance() {
        return fance;
    }

    public ArrayList<Painter> getP() {
        return p;
    }

    public PaintContainer getPc() {
        return pc;
    }

    public PaintProducer getPp() {
        return pp;
    }

    public Simulation(){
        this.state = new State();
        fance = new Fance(state);
        p = new ArrayList<>();
        pc = new PaintContainer();
        pp = new PaintProducer(pc, state);
        state.start();
        pc.setPaintProducer(pp);
        pp.start();
        for (int i = 0; i < Context.CountOfPainters(); i++) {
            String[] chars = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y"};
            Painter tmp = new Painter(fance, chars[i], pc, state);
            tmp.start();
            p.add(tmp);
        }
    }

    public void stop(){
        state.stop();
    }

    public static void main(String[] args) {
        new Printer(new Simulation()).start();
    }
}