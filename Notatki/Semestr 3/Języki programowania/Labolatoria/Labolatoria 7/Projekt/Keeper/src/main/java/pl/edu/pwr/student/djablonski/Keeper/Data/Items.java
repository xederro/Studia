package pl.edu.pwr.student.djablonski.Keeper.Data;

import pl.edu.pwr.tkubik.jp.shop.api.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Items implements ItemsCRUD {
    private Map<String, Item> items = new HashMap<>();

    public synchronized Item getItem(String key) {
        return items.get(key);
    }

    public synchronized void addItem(Item val) {
        items.put(val.getDescription(), val);
    }

    public synchronized void delItem(String key) {
        items.remove(key);
    }

    public synchronized int countItem(String key, int am) {
        return chCount(getItem(key), am);
    }

    private int chCount(Item i, int am) {
        int tmp;
        if (i.getQuantity()+am <= 0){
            tmp = i.getQuantity();
            i.setQuantity(0);
        } else {
            tmp = am;
            i.setQuantity(i.getQuantity() + am);;
        }

        if (tmp < 0){
            tmp = -tmp;
        }
        return tmp;
    }

    @Override
    public List<Item> getAllItems() {
        return List.of(items.values().toArray(new Item[0]));
    }
}
