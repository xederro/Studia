package pl.edu.pwr.student.djablonski.Seller.Handler;

import pl.edu.pwr.student.Common.Classes.Request;
import pl.edu.pwr.student.Common.Data.Order;
import pl.edu.pwr.student.djablonski.Seller.Seller;
import pl.edu.pwr.tkubik.jp.shop.api.ICallback;
import pl.edu.pwr.tkubik.jp.shop.api.ICustomer;
import pl.edu.pwr.tkubik.jp.shop.api.ISeller;
import pl.edu.pwr.tkubik.jp.shop.api.Item;

import java.rmi.RemoteException;
import java.util.List;

public class RequestHandler extends Request<Seller> implements ISeller {

    public RequestHandler(Seller s) throws RemoteException {
        super(s);
    }

    @Override
    public void acceptOrder(ICustomer ic, List<Item> boughtItemList, List<Item> returnedItemList) throws RemoteException {
        System.out.println("bought: " + boughtItemList);
        System.out.println("returned: " + returnedItemList);
        new Thread(()-> {
            try {
                getE().getKeeper().returnOrder(returnedItemList);
                getE().setOrder(new Order(ic, boughtItemList));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @Override
    public void response(ICallback ic, List<Item> itemList) throws RemoteException {
    }
}
