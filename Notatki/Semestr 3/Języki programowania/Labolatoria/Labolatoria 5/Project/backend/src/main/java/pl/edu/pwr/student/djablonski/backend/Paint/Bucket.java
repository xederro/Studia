package pl.edu.pwr.student.djablonski.backend.Paint;

import pl.edu.pwr.student.djablonski.backend.Context.Context;

public class Bucket {
    private Integer paint = Context.CountOfPlanksPerBucket();
    public Integer getPaint() {
        return paint;
    }
    public void refill() {
        this.paint = Context.CountOfPlanksPerBucket();
    }
    public boolean isEmpty() {
        return paint <= 0;
    }
    public void use() {
        paint--;
    }
}
