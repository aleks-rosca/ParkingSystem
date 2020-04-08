package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
    void message(String msg) throws RemoteException;
    IServerStatus getServerStatus() throws RemoteException;
    IServerGuestRes getServerGuestRes() throws  RemoteException;
    IServerMC getEmployeeServer() throws RemoteException;
    IServerGC getGateServer() throws RemoteException;
}
