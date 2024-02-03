package pl.edu.pwr.student.djablonski.Customer.Handler;

import pl.edu.pwr.student.Common.Classes.Request;
import pl.edu.pwr.student.Common.Data.Order;
import pl.edu.pwr.student.Common.Data.Person;
import pl.edu.pwr.student.Common.Enums.Role;
import pl.edu.pwr.student.djablonski.Customer.Customer;
import pl.edu.pwr.tkubik.jp.shop.api.ICallback;
import pl.edu.pwr.tkubik.jp.shop.api.ICustomer;
import pl.edu.pwr.tkubik.jp.shop.api.Item;

import java.rmi.RemoteException;
import java.util.List;

public class RequestHandler extends Request<Customer> implements ICustomer {
    public RequestHandler(Customer c) throws RemoteException {
        super(c);
    }

    @Override
    public void putOrder(ICallback idd, List<Item> itemList) throws RemoteException {
        new Thread(()->{
            System.out.println("Received order:" + itemList);
            getE().setDeliverer(new Person(Role.Deliverer, idd));

            getE().setOrder(new Order(idd, itemList));
        }).start();
    }

    @Override
    public void returnReceipt(String receipt) throws RemoteException {
        new Thread(()-> {
            System.out.println("Received receipt:" + receipt);
            getE().setRecipe(receipt);
        }).start();
    }

    @Override
    public void response(ICallback ic, List<Item> itemList) throws RemoteException {
        new Thread(()-> {
            System.out.println("Received stock:" + itemList);
            getE().setStock(itemList);
        }).start();
    }
}
