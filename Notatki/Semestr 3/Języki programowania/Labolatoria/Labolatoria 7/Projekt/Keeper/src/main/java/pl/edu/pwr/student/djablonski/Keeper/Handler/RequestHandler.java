package pl.edu.pwr.student.djablonski.Keeper.Handler;

import pl.edu.pwr.student.Common.Classes.Request;
import pl.edu.pwr.student.Common.Data.*;
import pl.edu.pwr.student.Common.Enums.Role;
import pl.edu.pwr.student.djablonski.Keeper.Data.ItemsCRUD;
import pl.edu.pwr.student.djablonski.Keeper.Data.OrderQueue;
import pl.edu.pwr.student.djablonski.Keeper.Data.PersonCRUD;
import pl.edu.pwr.student.djablonski.Keeper.Keeper;
import pl.edu.pwr.tkubik.jp.shop.api.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RequestHandler extends Request<Keeper> implements IKeeper {
    private final PersonCRUD personCRUD;
    private final OrderQueue orderQueue;
    private final ItemsCRUD itemsCRUD;
    private final List<ISeller> sellers;

    public RequestHandler(PersonCRUD personCRUD, OrderQueue orderQueue, ItemsCRUD itemsCRUD, List<ISeller> sellers, Keeper k) throws RemoteException {
        super(k);
        this.personCRUD = personCRUD;
        this.orderQueue = orderQueue;
        this.itemsCRUD = itemsCRUD;
        this.sellers = sellers;
    }

    @Override
    public int register(ICallback iCallback) throws RemoteException {
        if(iCallback instanceof ICustomer) {
            Person np = new Person(Role.Customer, iCallback);
            personCRUD.addPerson(np.getID(), np);
            System.out.println("Register Customer: " + np.getID());
            return np.getID();
        }
        if (iCallback instanceof IDeliverer) {
            Person np = new Person(Role.Deliverer, iCallback);
            personCRUD.addPerson(np.getID(), np);
            System.out.println("Register Deliverer: " + np.getID());
            return np.getID();
        }
        if(iCallback instanceof ISeller) {
            Person np = new Person(Role.Seller, iCallback);
            personCRUD.addPerson(np.getID(), np);
            sellers.add((ISeller)iCallback);
            System.out.println("Register Seller: " + np.getID());
            return np.getID();
        }
        return -1; // error
    }

    @Override
    public boolean unregister(int id) throws RemoteException {
        System.out.println("Unregister id: " + id);
        ICallback ic = personCRUD.getPerson(id).getIc();
        if(personCRUD.getPerson(id).getIc() instanceof ISeller){
            sellers.remove(ic);
        }
        personCRUD.delPerson(id);
        return true;
    }

    @Override
    public void getOffer(int idc) throws RemoteException {
        new Thread(()->{
            System.out.println(idc + " requested offer");
            Person p = personCRUD.getPerson(idc);
            if(p!=null) {
                try {
                    p.getIc().response(null,itemsCRUD.getAllItems());
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }

    @Override
    public void getOrder(int idd) throws RemoteException {
        new Thread(()->{
            System.out.println("Keeper received getOrder query from: " + idd);

            if (!orderQueue.isEmpty()) {
                Order o = orderQueue.getOrder();
                Person p = personCRUD.getPerson(idd);
                if (o != null && p != null){
                    o.items().forEach((Item i)-> {
                        int tmp = itemsCRUD.countItem(i.getDescription(), -i.getQuantity());
                        i.setQuantity(tmp);
                    });

                    try {
                        p.getIc().response(o.ic(),o.items());
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

    @Override
    public void returnOrder(List<Item> itemList) throws RemoteException {
        new Thread(()->{
            System.out.println("returned: " + itemList);
            itemList.forEach((Item i)-> itemsCRUD.countItem(i.getDescription(), i.getQuantity()));
        }).start();
    }

    @Override
    public void putOrder(int idc, List<Item> itemList) throws RemoteException {
        new Thread(()->{
            System.out.println("Keeper received putOrder query from: " + idc);
            Person p = personCRUD.getPerson(idc);
            if(p!=null){
                orderQueue.addOrder(new Order(p.getIc(), itemList));
            }
        }).start();
    }

    @Override
    public List<ISeller> getSellers() throws RemoteException {
        System.out.println("Got sellers");
        return sellers;
    }
}
