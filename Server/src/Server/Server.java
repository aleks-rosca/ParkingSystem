package Server;

import Model.IServerModel;
import Model.ServerModel;
import model.Employee;
import model.EmployeeRes;
import model.GuestRes;
import serverinterface.IServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Server extends UnicastRemoteObject implements IServer {
    private IServerModel model;


    public Server() throws RemoteException {
        model = new ServerModel();
        // UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void message(String msg) throws RemoteException {
        System.out.println(msg);
    }

    @Override
    public String addEmployee(Employee employee) throws RemoteException {
        return model.addEmployee(employee);


    }

    @Override
    public String addEmpRes(EmployeeRes employeeRes) throws RemoteException {
        return model.addEmpRes(employeeRes);


    }

    @Override
    public String empCheckIn(String empNo) throws RemoteException {
        return model.empCheckIn(empNo);
    }

    @Override
    public String empCheckOut(String empNo) throws RemoteException {
        return model.empCheckOut(empNo);
    }

    @Override
    public String addGuestRes(GuestRes guestRes) throws RemoteException {
        return model.addGuestRes(guestRes);
    }

    @Override
    public String guestCheckIn(String resNo) throws RemoteException {
        return model.guestCheckIn(resNo);
    }

    @Override
    public String guestCheckOut(String resNo) throws RemoteException {
        return model.guestCheckOut(resNo);
    }

    @Override
    public List<EmployeeRes> getEmpRes(String empNo) throws RemoteException {
        return model.getEmpRes(empNo);
    }
    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) throws RemoteException {
        return model.deleteEmpRes(employeeRes);
    }

}

