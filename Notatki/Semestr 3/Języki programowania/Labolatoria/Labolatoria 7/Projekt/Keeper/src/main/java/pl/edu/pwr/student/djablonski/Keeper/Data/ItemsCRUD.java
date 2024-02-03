package pl.edu.pwr.student.djablonski.Keeper.Data;

import pl.edu.pwr.tkubik.jp.shop.api.Item;

import java.util.List;

public interface ItemsCRUD {
    Item getItem(String key);
    void addItem(Item val);
    void delItem(String key);
    int countItem(String key, int am);
    List<Item> getAllItems();
}
