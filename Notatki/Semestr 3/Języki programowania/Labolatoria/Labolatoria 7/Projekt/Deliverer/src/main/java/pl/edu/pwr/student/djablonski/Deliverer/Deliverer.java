package pl.edu.pwr.student.djablonski.Deliverer;

import pl.edu.pwr.student.Common.Classes.SDCKCommon;
import pl.edu.pwr.student.djablonski.Deliverer.Executor.GetOrders;
import pl.edu.pwr.student.djablonski.Deliverer.Handler.RequestHandler;
import pl.edu.pwr.tkubik.jp.shop.api.ICustomer;
import pl.edu.pwr.tkubik.jp.shop.api.IKeeper;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Deliverer extends SDCKCommon {
    public Deliverer (String host, Integer port){
        super(true);
        try {
            Registry r = LocateRegistry.getRegistry(host, port);

            setKeeper((IKeeper) r.lookup("Keeper"));

            int idd = getKeeper().register(new RequestHandler(this));
            setIDe(idd);
            new GetOrders(this).start();
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
        if (getOrder() != null && getCustomer() != null && isAutomatic()){
            try {
                sleep(3000);
            } catch (Exception e){
                e.printStackTrace();
            }
            try{
                ((ICustomer)getCustomer().getIc()).putOrder(new RequestHandler(this), getOrder().items());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
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
    }

    public static void main(String[] args) {
        if (args.length >= 1){
            new Deliverer(args[0], Integer.parseInt(args[1]));
        } else {
            System.err.println("Wrong arguments");
        }
    }
}