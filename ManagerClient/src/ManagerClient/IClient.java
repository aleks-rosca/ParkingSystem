package ManagerClient;

import model.Employee;

import java.rmi.RemoteException;

public interface IClient {
    public void addEmployee(Employee employee) throws RemoteException;
}
