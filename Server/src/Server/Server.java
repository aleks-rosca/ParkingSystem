package Server;

import Model.IServerModel;
import Model.ServerModel;
import model.Employee;
import model.EmployeeRes;
import serverinterface.IServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
        return null;//model.empCheckIn(String empNo);
    }


}

