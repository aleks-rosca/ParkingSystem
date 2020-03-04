package ManagerClient;

import model.Employee;
import serverinterface.IServer;

import java.rmi.RemoteException;

public class Client implements IClient {
    public IServer serverInterface;

    public Client(IServer serverInterface) {
        this.serverInterface = serverInterface;

    }

    public void addEmployee(Employee employee) throws RemoteException {
        serverInterface.addEmployee(employee);
    }

}
