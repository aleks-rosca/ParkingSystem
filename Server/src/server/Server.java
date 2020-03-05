package server;

import DB.EmpDAO;
import DB.IEmpDAO;
import model.Employee;
import model.EmployeeRes;
import serverinterface.IServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements IServer {
    IEmpDAO empdb = new EmpDAO();

    public Server() throws RemoteException {
        // UnicastRemoteObject.exportObject(this, 0);
    }


    @Override
    public void message(String msg) throws RemoteException {
        System.out.println(msg);
    }

    @Override
    public boolean addEmployee(Employee employee) throws RemoteException {
        if (empdb.addEmployee(employee)) {

            return true;
        } else {
            return false;
        }

    }

    @Override
    public void addEmpRes(EmployeeRes employeeRes, Employee employee) throws RemoteException {
        if (empdb.checkEmployeeByEmpNumber(employee.getEmpNumber())) {
            empdb.addReservetion(employee, employeeRes);
        }


    }


}

