package ManagerClient;

import model.Employee;
import model.EmployeeRes;
import model.GuestRes;
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
    public String addEmployeeRes(EmployeeRes employeeRes) {
        try {
            return serverinterface.addEmpRes(employeeRes);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }

    }

    @Override
    public String addGuestRes(GuestRes guestRes) {
        try {
            return serverinterface.addGusetRes(guestRes);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }
}