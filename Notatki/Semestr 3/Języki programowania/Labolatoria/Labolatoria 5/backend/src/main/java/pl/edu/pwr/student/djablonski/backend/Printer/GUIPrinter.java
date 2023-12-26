package pl.edu.pwr.student.djablonski.backend.Printer;

import pl.edu.pwr.student.djablonski.backend.Context.Context;
import pl.edu.pwr.student.djablonski.backend.Simulation;

public class GUIPrinter extends Printer {
    private final GUIPrinterExecutioner exe;

    public GUIPrinter(GUIPrinterExecutioner exe) {
        super(new Simulation());
        this.exe = exe;
    }

    @Override
    public void run() {
        exe.onStart();
        while(state.isRunning()){
            try {
                sleep(Context.TimeBetweenPrints());
                exe.onPrint(this.toString());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        exe.onEnd();
    }
}
