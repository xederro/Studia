package pl.edu.pwr.student.djablonski.Deliverer.Executor;

import pl.edu.pwr.student.djablonski.Deliverer.Deliverer;

import java.rmi.RemoteException;
import java.util.Random;

public class GetOrders extends Thread {
    private Deliverer d;

    public GetOrders(Deliverer d){
        this.d = d;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (d.isAutomatic()){
            try {
                sleep(r.nextInt(3000, 10000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (d.getOrder() == null && d.getIDe() != null) {
                try {
                    d.getKeeper().getOrder(d.getIDe());
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
