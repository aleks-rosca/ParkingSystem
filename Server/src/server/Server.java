package server;

import DB.EmpDAO;
import DB.IEmpDAO;
import Model.Model;
import model.Employee;
import model.EmployeeRes;
import serverinterface.IServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements IServer {
    private Model model;


    public Server() throws RemoteException {
        model = new Model();
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
    public void addEmpRes(EmployeeRes employeeRes, Employee employee) throws RemoteException {

    }


}

