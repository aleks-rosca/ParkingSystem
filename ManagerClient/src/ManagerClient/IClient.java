package ManagerClient;

import model.Employee;
import model.EmployeeRes;

import java.rmi.RemoteException;

public interface IClient {
    public String addEmployee(Employee employee) throws RemoteException;
    public void addEmployeeRes(EmployeeRes employeeRes) throws RemoteException;
}
