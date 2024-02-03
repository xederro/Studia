package pl.edu.pwr.student.djablonski.Keeper.Data;

import pl.edu.pwr.student.Common.Data.Order;

public interface OrderQueue {
    Order getOrder();
    void addOrder(Order order);
    boolean isEmpty();
}
