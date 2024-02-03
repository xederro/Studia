package pl.edu.pwr.student.djablonski.Seller;

import pl.edu.pwr.student.Common.Classes.SDCKCommon;
import pl.edu.pwr.student.Common.Data.Order;
import pl.edu.pwr.student.djablonski.Seller.Handler.RequestHandler;
import pl.edu.pwr.tkubik.jp.shop.api.ICustomer;
import pl.edu.pwr.tkubik.jp.shop.api.IKeeper;
import pl.edu.pwr.tkubik.jp.shop.api.Item;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Seller extends SDCKCommon {
    public Seller(String host, Integer port){
        super(true);
        try {
            Registry r = LocateRegistry.getRegistry(host, port);

            setKeeper((IKeeper) r.lookup("Keeper"));

            setIDe(getKeeper().register(new RequestHandler(this)));

            Runtime.getRuntime().addShutdownHook(new Thread(()-> {
                try {
                    getKeeper().unregister(getIDe());
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }));
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onSetCustomer() {
        Order o = getOrder();
        if (o != null && isAutomatic()){
            try {
                sleep(3000);
            } catch (Exception e){
                e.printStackTrace();
            }
            StringBuilder sb = new StringBuilder();
            for (Item i : o.items()){
                sb.append(i.getDescription()).append(":").append(i.getQuantity()).append(", ");
            }

            new Thread(()-> {
                try {
                    ((ICustomer)o.ic()).returnReceipt(sb.toString());
                    setOrder(null);
                    setCustomer(null);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

    @Override
    protected void onSetOrder() {
        if (getOrder() != null && isAutomatic()){
            try {
                sleep(3000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        onSetCustomer();
    }

    public static void main(String[] args) {
        if (args.length >= 1){
            new Seller(args[0], Integer.parseInt(args[1]));
        } else {
            System.err.println("Wrong arguments");
        }
    }
}