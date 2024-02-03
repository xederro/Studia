package pl.edu.pwr.student.Common.Classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public abstract class Handler<T extends SDCKCommon> extends UnicastRemoteObject {
    private final T e;

    protected Handler(T e) throws RemoteException {
        super();
        this.e = e;
    }

    protected T getE() {
        return e;
    }
}
