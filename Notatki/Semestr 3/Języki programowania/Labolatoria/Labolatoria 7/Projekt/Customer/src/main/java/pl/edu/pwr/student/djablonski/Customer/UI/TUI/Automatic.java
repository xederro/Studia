package pl.edu.pwr.student.djablonski.Customer.UI.TUI;

import pl.edu.pwr.student.Common.Data.Person;
import pl.edu.pwr.student.Common.Enums.Role;
import pl.edu.pwr.student.djablonski.Customer.Customer;
import pl.edu.pwr.student.djablonski.Customer.Handler.RequestHandler;
import pl.edu.pwr.student.djablonski.Customer.UI.UI;
import pl.edu.pwr.tkubik.jp.shop.api.IDeliverer;
import pl.edu.pwr.tkubik.jp.shop.api.ISeller;
import pl.edu.pwr.tkubik.jp.shop.api.Item;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Automatic extends Thread implements UI {
    private Customer C;

    public Automatic(Customer C){
        super();
        this.C = C;
    }
    @Override
    public void getRecipe() {
        try {
            sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void getSeller() {
        if (C.getOrder() != null && C.getSeller() != null){
            try {
                sleep(3000);
            } catch (Exception e){
                e.printStackTrace();
            }

            try {
                ((ISeller)C.getSeller().getIc()).acceptOrder(new RequestHandler(C), C.getOrder().items(), C.retD);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void getDeliverer() {
        if (C.getOrder() != null && C.getDeliverer() != null){
            try {
                sleep(3000);
            } catch (Exception e){
                e.printStackTrace();
            }

            try {
                ((IDeliverer)C.getDeliverer().getIc()).returnOrder(C.retD);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void getOrder() {
        if (C.getOrder() != null){
            try {
                sleep(3000);
            } catch (Exception e){
                e.printStackTrace();
            }
            Random r = new Random();
            C.retD = new ArrayList<>();
            C.retS = new ArrayList<>();

            for (int i = C.getOrder().items.length - 1; i >= 0; i--) {
                Item item = C.getOrder().items[i];
                if (r.nextInt(100) < 23){
                    if (r.nextInt(100) < 30){
                        C.retD.add(item);
                        C.getOrder().delItem(item);
                    } else {
                        C.retS.add(item);
                        C.getOrder().delItem(item);
                    }
                }
            }
            try{
                ((IDeliverer)C.getDeliverer().getIc()).returnOrder(C.retD);
                List<ISeller> is = C.getKeeper().getSellers();
                C.setSeller(new Person(Role.Seller, is.get(r.nextInt(0, is.size()))));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void getID() {
        try {
            sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            C.getKeeper().getOffer(C.getIDe());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void putOrder(List<Item> stock) {
        if (stock != null) {
            try {
                sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Random r = new Random();
            ArrayList<Item> order = new ArrayList<>();

            for (Item item:stock) {
                if (item.getQuantity() != 0 && r.nextInt(100) < 27) {
                    item.setQuantity(r.nextInt(0, item.getQuantity()));
                    order.add(item);
                }
            }

            if (!order.isEmpty()) {
                try{
                    C.getKeeper().putOrder(C.getIDe(), order);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
