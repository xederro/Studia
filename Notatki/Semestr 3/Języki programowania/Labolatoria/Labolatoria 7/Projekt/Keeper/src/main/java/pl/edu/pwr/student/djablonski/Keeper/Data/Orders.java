package pl.edu.pwr.student.djablonski.Keeper.Data;

import pl.edu.pwr.student.Common.Data.Order;

import java.util.LinkedList;
import java.util.Queue;

public class Orders implements OrderQueue{
    private final Queue<Order> orders = new LinkedList<>();

    @Override
    public synchronized Order getOrder() {
        return orders.poll();
    }

    @Override
    public synchronized void addOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public boolean isEmpty() {
        return orders.isEmpty();
    }
}
