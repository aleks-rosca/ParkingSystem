package ManagerClient;

import model.Employee;

import java.rmi.RemoteException;

public interface IClient {
    public boolean addEmployee(Employee employee) throws RemoteException;
}
