package pl.edu.pwr.student.Common.Data;

import pl.edu.pwr.tkubik.jp.shop.api.ICallback;
import pl.edu.pwr.tkubik.jp.shop.api.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    public ICallback ic;
    public Item[] items;
    public Order(ICallback ic, Item[] items){
        this.items = items;
        this.ic = ic;
    }

    public Order(){}

    public Order(ICallback ic, List<Item> itemList) {
        this.items = itemList.toArray(new Item[]{});
        this.ic = ic;
    }


    public void delItem(Item i){
        ArrayList<Item> ALI = new ArrayList<>(List.of(items));
        ALI.remove(i);
        items = ALI.toArray(new Item[]{});
    }

    public ICallback ic() {
        return ic;
    }

    public List<Item> items() {
        return List.of(items);
    }

    public Integer itemIndex(String desc){
        for (int i = 0; i < items.length; i++) {
            if (Objects.equals(items[i].getDescription(), desc)){
                return i;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("IDc=")
                .append(ic.toString())
                .append(", items=");

        for (Item i : items){
            sb.append(i.toString());
        }

        return sb.toString();
    }
}
