package serverinterface;


import model.Employee;
import model.EmployeeRes;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote , Serializable {
    public void message(String msg) throws RemoteException;
    public String addEmployee(Employee employee) throws RemoteException;
    public String addEmpRes(EmployeeRes employeeRes) throws RemoteException;
}
