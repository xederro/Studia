package pl.edu.pwr.student.djablonski.backend.Workers;

import pl.edu.pwr.student.djablonski.backend.Context.Context;
import pl.edu.pwr.student.djablonski.backend.Fance.Fance;
import pl.edu.pwr.student.djablonski.backend.Fance.Plank;
import pl.edu.pwr.student.djablonski.backend.Paint.Bucket;
import pl.edu.pwr.student.djablonski.backend.Paint.PaintContainer;

public class Painter extends Thread{
    private final Bucket bucket;
    private final Fance fance;
    private final String symbol;
    private final PaintContainer pc;
    private Plank plank = null;
    private final pl.edu.pwr.student.djablonski.backend.State.State state;

    public Painter(Fance fance, String symbol, PaintContainer pc, pl.edu.pwr.student.djablonski.backend.State.State state) {
        this.state = state;
        bucket = new Bucket();
        this.fance = fance;
        this.symbol = symbol;
        this.pc = pc;
    }

    public int getBucket(){
        return bucket.getPaint();
    }

    @Override
    public void run() {
        while (state.isRunning()){
            try {
                sleep(Context.DurationOfWorkerOperation());
                if (bucket.isEmpty()){
                    pc.refillBucket(bucket, symbol);
                } else {
                    plank = fance.next(plank);
                    if (plank != null){
                        plank.paint(symbol);
                        bucket.use();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return symbol;
    }
}
