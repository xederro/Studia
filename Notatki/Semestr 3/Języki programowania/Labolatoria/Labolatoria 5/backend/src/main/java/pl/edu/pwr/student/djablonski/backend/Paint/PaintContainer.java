package pl.edu.pwr.student.djablonski.backend.Paint;

import pl.edu.pwr.student.djablonski.backend.Context.Context;
import pl.edu.pwr.student.djablonski.backend.Workers.PaintProducer;

public class PaintContainer extends Thread{

    private Integer paint = Context.CountOfBucketsInTank();
    private String symbol = ".";
    private PaintProducer pp;


    public synchronized void refillBucket(Bucket b, String symbol){
        if (paint == 0){
            pp.inform();
            try {
                wait();
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            try {
                this.symbol = symbol;
                sleep(Context.DurationOfFillingBucket());
                b.refill();
                paint--;
                this.symbol = ".";
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void setPaintProducer (PaintProducer pp) {
        this.pp = pp;
    }

    public synchronized void refillContainer(){
        paint = Context.CountOfBucketsInTank();
        notifyAll();
        try {
            wait();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toString() {
        return paint.toString() + "] " + symbol;
    }
}
