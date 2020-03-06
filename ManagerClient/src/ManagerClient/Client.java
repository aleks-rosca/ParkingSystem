package ManagerClient;

import model.Employee;
import model.EmployeeRes;
import serverinterface.IServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client implements IClient {
    private IServer serverinterface;

    public Client() throws RemoteException, NotBoundException, MalformedURLException {
        serverinterface = (IServer) Naming.lookup("rmi://localhost:1099/IPMS");
        serverinterface.message("Manager Connected");
    }

    @Override
    public String addEmployee(Employee employee) throws RemoteException {
        return serverinterface.addEmployee(employee);
    }

    @Override
    public void addEmployeeRes(EmployeeRes employeeRes) throws RemoteException {
        serverinterface.addEmpRes(employeeRes);

    }
}