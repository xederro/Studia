package pl.edu.pwr.student.djablonski.Deliverer.Handler;

import pl.edu.pwr.student.Common.Classes.Request;
import pl.edu.pwr.student.djablonski.Deliverer.Deliverer;
import pl.edu.pwr.tkubik.jp.shop.api.ICallback;
import pl.edu.pwr.tkubik.jp.shop.api.ICustomer;
import pl.edu.pwr.tkubik.jp.shop.api.IDeliverer;
import pl.edu.pwr.tkubik.jp.shop.api.Item;

import java.rmi.RemoteException;
import java.util.List;


public class RequestHandler extends Request<Deliverer> implements IDeliverer {

    public RequestHandler(Deliverer d) throws RemoteException {
        super(d);
    }

    @Override
    public void returnOrder(List<Item> itemList) throws RemoteException {
        new Thread(()->{
            try {
                System.out.println("returned: " + itemList);
                getE().getKeeper().returnOrder(itemList);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @Override
    public void response(ICallback ic, List<Item> itemList) throws RemoteException {
        new Thread(()->{
            System.out.println("giving items: " + itemList);
            try {
                ((ICustomer) ic).putOrder(this,itemList);
                getE().setOrder(null);
                getE().setCustomer(null);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
