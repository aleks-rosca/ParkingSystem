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
    public List<EmployeeRes> getEmpResByEmpNo(String empNo) throws RemoteException {
        return model.getEmpResByEmpNo(empNo);
    }

    @Override
    public List<EmployeeRes> getAllEmpReservations() throws RemoteException {
        return model.getAllEmpReservation();
    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) throws RemoteException {
        return model.deleteEmpRes(employeeRes);
    }

    @Override
    public String cancelGuestRes(String resNo) throws RemoteException {
        return model.cancelGuestRes(resNo);
    }

    @Override
    public List<GuestRes> getAllGuestReserevation() throws RemoteException {
        return model.getAllGuestReserevation();
    }

    @Override
    public String getEmployeeNameByEmpNo(String empNo) throws RemoteException {
        return model.getEmployeeNameByEmpNo(empNo);
    }

    @Override
    public List<Employee> getAllEmployees() throws RemoteException {
        return model.getAllEmployee();
    }

    @Override
    public String deleteEmployee(Employee employee) throws RemoteException {
        return model.deleteEmployee(employee);
    }

    @Override
    public String updateEmployee(Employee newEmployee, String empNo) throws RemoteException {
        return model.updateEmployee(newEmployee,empNo);
    }

    @Override
    public int getParkingStatus() throws RemoteException {
        return model.getParkingStatus();
    }
}

