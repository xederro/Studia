package pl.edu.pwr.student.Common.Classes;

import java.rmi.RemoteException;

public abstract class Request<T extends SDCKCommon> extends Handler<T> {

    protected Request(T e) throws RemoteException {
        super(e);
    }
}
