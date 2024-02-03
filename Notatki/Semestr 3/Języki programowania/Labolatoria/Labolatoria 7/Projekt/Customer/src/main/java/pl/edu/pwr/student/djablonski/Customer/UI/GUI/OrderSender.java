package pl.edu.pwr.student.djablonski.Customer.UI.GUI;

import pl.edu.pwr.tkubik.jp.shop.api.Item;

import java.util.ArrayList;

@FunctionalInterface
public interface OrderSender {
    void sendOrder(ArrayList<Item> order);
}
