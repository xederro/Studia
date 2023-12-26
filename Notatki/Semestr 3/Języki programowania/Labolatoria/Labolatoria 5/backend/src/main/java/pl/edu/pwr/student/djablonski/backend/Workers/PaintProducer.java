package pl.edu.pwr.student.djablonski.backend.Workers;

import pl.edu.pwr.student.djablonski.backend.Context.Context;
import pl.edu.pwr.student.djablonski.backend.Paint.PaintContainer;

public class PaintProducer extends Thread{

    private Integer roadTime = Context.DistanceBetweenPaintproducerAndPainters();
    private boolean inRoad = false;
    private boolean filling = false;
    private final PaintContainer pc;
    private final pl.edu.pwr.student.djablonski.backend.State.State state;

    public PaintProducer(PaintContainer pc, pl.edu.pwr.student.djablonski.backend.State.State state) {
        this.state = state;
        this.pc = pc;
    }
    @Override
    public void run() {
        while (state.isRunning()){
            try {
                sleep(Context.DurationOfWorkerOperation());
                if (inRoad){
                    roadTime--;
                    if (roadTime <= 0){
                        filling = true;
                        sleep(Context.DurationOfFillingPaintContainer());
                        roadTime = Context.DistanceBetweenPaintproducerAndPainters();
                        filling = false;
                        inRoad = false;
                        pc.refillContainer();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void inform(){
        if (!inRoad){
            notify();
            inRoad=true;
        } else {
            roadTime--;
        }
    }

    @Override
    public String toString() {
        if(filling){
            return "Z [";
        }
        return ". [";
    }
}
