package ManagerClient;

import model.Employee;
import model.EmployeeRes;
import serverinterface.IServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ManagerClient implements IManagerClient {
    private IServer serverinterface;

    public ManagerClient() throws RemoteException, NotBoundException, MalformedURLException {
        serverinterface = (IServer) Naming.lookup("rmi://localhost:1099/IPMS");
        serverinterface.message("Manager Connected");
    }

    @Override
    public String addEmployee(Employee employee) {
        try {
            return serverinterface.addEmployee(employee);
        } catch (RemoteException e) {
            return "Error";
        }
    }

    @Override
    public void addEmployeeRes(EmployeeRes employeeRes) {
        try {
            serverinterface.addEmpRes(employeeRes);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}