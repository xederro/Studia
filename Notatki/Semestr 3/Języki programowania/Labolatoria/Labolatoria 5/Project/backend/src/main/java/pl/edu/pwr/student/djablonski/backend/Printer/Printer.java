package pl.edu.pwr.student.djablonski.backend.Printer;

import pl.edu.pwr.student.djablonski.backend.Context.Context;
import pl.edu.pwr.student.djablonski.backend.Simulation;
import pl.edu.pwr.student.djablonski.backend.Workers.Painter;


public class Printer extends Thread {
    private final Simulation simulation;
    protected pl.edu.pwr.student.djablonski.backend.State.State state;

    public Printer(Simulation simulation) {
        this.simulation = simulation;
        state = simulation.state;
    }

    @Override
    public void run() {
        while(state.isRunning()){
            try {
                sleep(Context.TimeBetweenPrints());
                System.out.println(this);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void end(){
        simulation.stop();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(simulation.getPp().toString())
                .append(simulation.getPc().toString())
                .append("\n");

        StringBuilder r1 = new StringBuilder();
        StringBuilder r2 = new StringBuilder();
        for (Painter painter : simulation.getP()) {
            r1.append(painter)
                    .append(" ");
            r2.append(painter.getBucket())
                    .append(" ");
        }

        sb.append(r1)
                .append("\n")
                .append(r2)
                .append("\n")
                .append(simulation.getFance().toString());

        return sb.toString();
    }
}
