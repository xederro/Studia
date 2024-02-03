package pl.edu.pwr.student.djablonski.Customer.UI;

import pl.edu.pwr.tkubik.jp.shop.api.Item;

import java.util.List;

public interface UI {
    void getRecipe();
    void getSeller();
    void getDeliverer();
    void getOrder();
    void getID();
    void putOrder(List<Item> stock);
}
