package pl.edu.pwr.student.djablonski.Customer;

import pl.edu.pwr.student.Common.Classes.SDCKCommon;
import pl.edu.pwr.student.djablonski.Customer.Handler.RequestHandler;
import pl.edu.pwr.student.djablonski.Customer.UI.GUI.GUI;
import pl.edu.pwr.student.djablonski.Customer.UI.TUI.Automatic;
import pl.edu.pwr.student.djablonski.Customer.UI.UI;
import pl.edu.pwr.tkubik.jp.shop.api.IKeeper;
import pl.edu.pwr.tkubik.jp.shop.api.Item;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Customer extends SDCKCommon {
    private String recipe;
    private List<Item> stock;
    public ArrayList<Item> retD;
    public ArrayList<Item> retS;
    private UI UI;

    public Customer(String host, Integer port, boolean isAutomatic){
        super(isAutomatic);
        if (isAutomatic){
            UI = new Automatic(this);
        } else {
            UI = new GUI(this);
            GUI.start((GUI) UI);
        }

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


    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
        UI.getRecipe();
    }


    public void setStock(List<Item> stock) {
        this.stock = stock;
        UI.putOrder(stock);
    }

    @Override
    protected void onSetSeller() {
        UI.getSeller();
    }

    @Override
    protected void onSetDeliverer() {
        UI.getDeliverer();
    }

    @Override
    protected void onSetOrder() {
        UI.getOrder();
    }

    @Override
    protected void onSetID() {
        UI.getID();
    }

    public static void main(String[] args) {
        if (args.length >= 2){
            boolean auto = false;
            if (args.length == 3)
                auto = Boolean.parseBoolean(args[2]);
            new Customer(args[0], Integer.parseInt(args[1]), auto);
        } else {
            System.err.println("Wrong arguments");
        }
    }
}