package pl.edu.pwr.student.Common.Classes;

import pl.edu.pwr.student.Common.Data.Order;
import pl.edu.pwr.student.Common.Data.Person;
import pl.edu.pwr.tkubik.jp.shop.api.IKeeper;

public abstract class SDCKCommon extends Thread {
    private IKeeper keeper;
    private Integer IDe;
    private Order order;
    private Person deliverer;
    private Person customer;

    private Person seller;
    private final boolean isAutomatic;

    public SDCKCommon(boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public Integer getIDe() {
        return IDe;
    }

    public void setIDe(Integer IDe) {
        this.IDe = IDe;
        onSetID();
    }

    public synchronized Order getOrder() {
        return order;
    }

    public synchronized void setOrder(Order order) {
        this.order = order;
        onSetOrder();
    }

    public Person getSeller() {
        return seller;
    }

    public void setSeller(Person seller) {
        this.seller = seller;
        onSetSeller();
    }

    public Person getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Person deliverer) {
        this.deliverer = deliverer;
        onSetDeliverer();
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
        onSetCustomer();
    }

    public void setKeeper(IKeeper keeper) {
        this.keeper = keeper;
    }

    public IKeeper getKeeper() {
        return keeper;
    }

    protected void onSetSeller(){
        return;
    };
    protected void onSetDeliverer(){
        return;
    };
    protected void onSetOrder(){
        return;
    };
    protected void onSetCustomer(){
        return;
    };
    protected void onSetID(){
        return;
    };
}
