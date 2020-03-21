package ManagerClient;

import model.Employee;
import model.EmployeeRes;
import model.GuestRes;
import serverinterface.IServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

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
    public List<Employee> getAllEmployee() {
        try {
            return serverinterface.getAllEmployees();
        } catch (RemoteException e) {

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getEmployeeNameByEmpNo(String empNo) {
        try {
            return serverinterface.getEmployeeNameByEmpNo(empNo);
        } catch (RemoteException e) {

            e.printStackTrace();
            return "error";
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
            return serverinterface.addGuestRes(guestRes);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public String cancelGuestRes(String resNo) {
        try {
            return serverinterface.cancelGuestRes(resNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<GuestRes> getAllGuestReserevation() {
        try {
            return serverinterface.getAllGuestReserevation();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<EmployeeRes> getAllReservationByEmpNo(String empNo) {
        try {

            return serverinterface.getEmpResByEmpNo(empNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<EmployeeRes> getAllEmpReservations() {
        try {
            return serverinterface.getAllEmpReservations();
        } catch (RemoteException e) {

            e.printStackTrace();
            return null;
        }
    }
    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        try {
            return serverinterface.deleteEmpRes(employeeRes);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}