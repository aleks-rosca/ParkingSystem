package Server;

import Interface.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements IServer {
    public Server() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void message(String msg) {
        System.out.println(msg);
    }
    @Override
    public IServerStatus getServerStatus() throws RemoteException {
        return new ServerStatus();
    }

    @Override
    public IServerGuestRes getServerGuestRes() throws RemoteException {
        return new ServerGuestRes();
    }

    @Override
    public IServerMC getEmployeeServer() throws RemoteException {
        return new ServerEmp();
    }

    @Override
    public IServerGC getGateServer() throws RemoteException {
        return new ServerGate();
    }
}
