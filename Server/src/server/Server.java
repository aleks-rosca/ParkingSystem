package server;


import model.Employee;
import serverinterface.IServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements IServer{

    public Server() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }


    @Override
    public void addEmployee(Employee employee) throws RemoteException {

    }
}
