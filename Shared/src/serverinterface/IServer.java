package serverinterface;


import model.Employee;
import model.EmployeeRes;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote , Serializable {
    public void message(String msg) throws RemoteException;
    public boolean addEmployee(Employee employee) throws RemoteException;
    public void addEmpRes(EmployeeRes employeeRes) throws RemoteException;
}
