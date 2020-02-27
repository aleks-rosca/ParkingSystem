package serverinterface;


import model.Employee;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
    public void addEmployee(Employee employee) throws RemoteException;
}
