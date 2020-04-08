package ManagerClient;

import Interface.IServer;
import model.Employee;
import model.EmployeeRes;
import model.GuestRes;
import model.Status;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class ManagerClient implements IManagerClient, IManagerClientS , IManagerClientG{
    private IServer sInterfaceM;

    public ManagerClient() throws RemoteException, NotBoundException, MalformedURLException {
        sInterfaceM = (IServer) Naming.lookup("rmi://localhost:1099/IPMS");
        sInterfaceM.message("Manager Connected");
    }

    @Override
    public String addEmployee(Employee employee) {
        try {
            return sInterfaceM.getEmployeeServer().addEmployee(employee);
        } catch (RemoteException e) {
            return "Error";
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        try {
            return sInterfaceM.getEmployeeServer().getAllEmployees();
        } catch (RemoteException e) {

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String addEmployeeRes(EmployeeRes employeeRes) {
        try {
            return sInterfaceM.getEmployeeServer().addEmpRes(employeeRes);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }

    }

    @Override
    public String addGuestRes(GuestRes guestRes) {
        try {
            return sInterfaceM.getServerGuestRes().addGuestRes(guestRes);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public String cancelGuestRes(String resNo) {
        try {
            return sInterfaceM.getServerGuestRes().cancelGuestRes(resNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<GuestRes> getAllGuestReservation() {
        try {
            return sInterfaceM.getServerGuestRes().getAllGuestReservation();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Status> getAllStatues() {
        try {
            return sInterfaceM.getServerStatus().getAllStatuses();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getCurrentStatus() {
        try {

            return sInterfaceM.getServerStatus().getParkingStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getNumberOfGuestsInParkingLot() {
        try {
            return sInterfaceM.getServerStatus().getNumberOfGuestsInParkingLot();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getNumberOfEmployeesInParkingLot() {
        try {
            return sInterfaceM.getServerStatus().getNumberOfEmployeesInParkingLot();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getNumberOfPublicUsersInParkingLot() {
        try {
            return sInterfaceM.getServerStatus().getNumberOfPublicUsersInParkingLot();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<EmployeeRes> getAllReservationByEmpNo(String empNo) {
        try {

            return sInterfaceM.getEmployeeServer().getEmpResByEmpNo(empNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<EmployeeRes> getAllEmpReservations() {
        try {
            return sInterfaceM.getEmployeeServer().getAllEmpReservations();
        } catch (RemoteException e) {

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        try {
            return sInterfaceM.getEmployeeServer().deleteEmpRes(employeeRes);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @Override
    public String deleteEmployee(Employee employee) {
        try {
            return sInterfaceM.getEmployeeServer().deleteEmployee(employee);
        } catch (RemoteException e) {

            e.printStackTrace();
            return "Error";
        }
    }

    @Override
    public String updateEmployee(Employee newEmployee, String empNo) {
        try {
            return sInterfaceM.getEmployeeServer().updateEmployee(newEmployee, empNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}