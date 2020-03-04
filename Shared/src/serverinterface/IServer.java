package serverinterface;


import model.Employee;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote , Serializable {
    public void message(String msg) throws RemoteException;
    public void addEmployee(Employee employee) throws RemoteException;
}
