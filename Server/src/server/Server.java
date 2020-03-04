package server;


import DB.EmpDAO;
import DB.IEmpDAO;
import model.Employee;
import serverinterface.IServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements IServer{
    IEmpDAO empdb = new EmpDAO();

    public Server() throws RemoteException {
       // UnicastRemoteObject.exportObject(this, 0);
    }


    @Override
    public void message(String msg) throws RemoteException {
        System.out.println(msg);
    }

    @Override
    public void addEmployee(Employee employee) throws RemoteException {
        empdb.addEmployee(employee);
        System.out.println(employee + "test");

    }
}
