package ManagerClient;

import model.Employee;
import model.EmployeeRes;

import java.rmi.RemoteException;

public interface IClient {
    public boolean addEmployee(Employee employee) throws RemoteException;
    public void addEmployeeRes(EmployeeRes employeeRes, Employee employee) throws RemoteException;
}
