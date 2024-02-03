package pl.edu.pwr.student.djablonski.Keeper;

import pl.edu.pwr.student.Common.Classes.SDCKCommon;
import pl.edu.pwr.student.djablonski.Keeper.Data.*;
import pl.edu.pwr.student.djablonski.Keeper.Handler.RequestHandler;
import pl.edu.pwr.tkubik.jp.shop.api.IKeeper;
import pl.edu.pwr.tkubik.jp.shop.api.ISeller;
import pl.edu.pwr.tkubik.jp.shop.api.Item;

import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public class Keeper extends SDCKCommon {
    private final ItemsCRUD itemsCRUD = new Items();
    private final OrderQueue orderQueue = new Orders();
    private final PersonCRUD personCRUD = new Persons();
    private final List<ISeller> sellers = new LinkedList<>();

    public Keeper (Integer port) throws RemoteException {
        super(true);

        itemsCRUD.addItem(new Item("Casual Sneakers", 29));
        itemsCRUD.addItem(new Item("Running Shoes", 39));
        itemsCRUD.addItem(new Item("Formal Loafers", 49));
        itemsCRUD.addItem(new Item("Athletic Trainers", 34));
        itemsCRUD.addItem(new Item("Classic Boots", 44));
        itemsCRUD.addItem(new Item("Fashion Sandals", 22));
        itemsCRUD.addItem(new Item("Hiking Boots", 49));
        itemsCRUD.addItem(new Item("Canvas Slip-Ons", 19));
        itemsCRUD.addItem(new Item("High-Top Sneakers", 37));
        itemsCRUD.addItem(new Item("Leather Oxfords", 45));
        itemsCRUD.addItem(new Item("Summer Flip-Flops", 14));
        itemsCRUD.addItem(new Item("Trail Running Shoes", 42));
        itemsCRUD.addItem(new Item("Platform Sneakers", 29));
        itemsCRUD.addItem(new Item("Slip-Resistant Work Shoes", 47));
        itemsCRUD.addItem(new Item("Velcro Strap Sandals", 24));
        itemsCRUD.addItem(new Item("Steel Toe Boots", 54));
        itemsCRUD.addItem(new Item("Basketball Shoes", 39));
        itemsCRUD.addItem(new Item("Elegant Pumps", 27));
        itemsCRUD.addItem(new Item("Winter Snow Boots", 49));
        itemsCRUD.addItem(new Item("Memory Foam Slippers", 19));
        itemsCRUD.addItem(new Item("Ankle Strap Heels", 32));
        itemsCRUD.addItem(new Item("Trendy Mules", 25));
        itemsCRUD.addItem(new Item("Skateboarding Shoes", 34));
        itemsCRUD.addItem(new Item("Classic Derby Shoes", 42));
        itemsCRUD.addItem(new Item("Chukka Boots", 29));
        itemsCRUD.addItem(new Item("Espadrille Flats", 21));
        itemsCRUD.addItem(new Item("Rain Boots", 44));
        itemsCRUD.addItem(new Item("Driving Loafers", 37));
        itemsCRUD.addItem(new Item("Bowling Shoes", 29));
        itemsCRUD.addItem(new Item("Rugged Sandals", 19));
        itemsCRUD.addItem(new Item("Minimalist Running Shoes", 34));
        itemsCRUD.addItem(new Item("Ballet Flats", 24));
        itemsCRUD.addItem(new Item("Golf Shoes", 42));
        itemsCRUD.addItem(new Item("Slingback Sandals", 28));
        itemsCRUD.addItem(new Item("Workout Cross Trainers", 39));
        itemsCRUD.addItem(new Item("Driving Moccasins", 31));
        itemsCRUD.addItem(new Item("Pointed Toe Booties", 49));
        itemsCRUD.addItem(new Item("Waterproof Hiking Boots", 44));
        itemsCRUD.addItem(new Item("Wedge Sandals", 26));
        itemsCRUD.addItem(new Item("Tennis Shoes", 37));
        itemsCRUD.addItem(new Item("Suede Chelsea Boots", 48));
        itemsCRUD.addItem(new Item("Casual Slipper Shoes", 18));
        itemsCRUD.addItem(new Item("Strappy High Heels", 29));
        itemsCRUD.addItem(new Item("Trail Hiking Shoes", 41));
        itemsCRUD.addItem(new Item("Platform Espadrilles", 23));
        itemsCRUD.addItem(new Item("Arch Support Insoles", 14));

        Registry r = LocateRegistry.createRegistry(port);

        IKeeper ik = new RequestHandler(personCRUD, orderQueue, itemsCRUD, sellers, this);

        r.rebind("Keeper", ik);

        Runtime.getRuntime().addShutdownHook(new Thread(()-> {
            try {
                UnicastRemoteObject.unexportObject(ik, true);
            } catch (NoSuchObjectException e) {
                throw new RuntimeException(e);
            }
        }));
    }


    public static void main(String[] args) throws RemoteException {
        if (args.length > 0){
            new Keeper(Integer.parseInt(args[0]));
        } else {
            System.err.println("Wrong arguments");
        }
    }
}
