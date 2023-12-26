package pl.edu.pwr.student.djablonski.backend.State;

public class State {
    private boolean end = false;

    public boolean isRunning() {
        return !end;
    }

    public void stop(){
        end = true;
    }
    public void start(){
        end = false;
    }
}
