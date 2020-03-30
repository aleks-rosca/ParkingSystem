package ManagerClient;

import Interface.IServerMC;
import model.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class ManagerClient implements IManagerClient {
    private IServerMC sInterfaceM;

    public ManagerClient() throws RemoteException, NotBoundException, MalformedURLException {
        sInterfaceM = (IServerMC) Naming.lookup("rmi://localhost:1099/IPMS");
        sInterfaceM.message("Manager Connected");
    }

    @Override
    public String addEmployee(Employee employee) {
        try {
            return sInterfaceM.addEmployee(employee);
        } catch (RemoteException e) {
            return "Error";
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        try {
            return sInterfaceM.getAllEmployees();
        } catch (RemoteException e) {

            e.printStackTrace();
            return null;
        }
    }



    @Override
    public String addEmployeeRes(EmployeeRes employeeRes) {
        try {
            return sInterfaceM.addEmpRes(employeeRes);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }

    }

    @Override
    public String addGuestRes(GuestRes guestRes) {
        try {
            return sInterfaceM.addGuestRes(guestRes);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public String cancelGuestRes(String resNo) {
        try {
            return sInterfaceM.cancelGuestRes(resNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<GuestRes> getAllGuestReserevation() {
        try {
            return sInterfaceM.getAllGuestReservation();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Status> getAllStatues() {
        try {
            return sInterfaceM.getAllStatuses();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getCurrentStatus() {
        try {

            return sInterfaceM.getParkingStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getNumberOfGuestsInParkingLot() {
        try {
            return sInterfaceM.getNumberOfGuestsInParkingLot();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getNumberOfEmployeesInParkingLot() {
        try {
            return sInterfaceM.getNumberOfEmployeesInParkingLot();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getNumberOfPublicUsersInParkingLot() {
        try {
            return sInterfaceM.getNumberOfPublicUsersInParkingLot();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<EmployeeRes> getAllReservationByEmpNo(String empNo) {
        try {

            return sInterfaceM.getEmpResByEmpNo(empNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<EmployeeRes> getAllEmpReservations() {
        try {
            return sInterfaceM.getAllEmpReservations();
        } catch (RemoteException e) {

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        try {
            return sInterfaceM.deleteEmpRes(employeeRes);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @Override
    public String deleteEmployee(Employee employee) {
        try {
            return sInterfaceM.deleteEmployee(employee);
        } catch (RemoteException e) {

            e.printStackTrace();
            return "Error";
        }
    }

    @Override
    public String updateEmployee(Employee newEmployee, String empNo) {
        try {
            return sInterfaceM.updateEmployee(newEmployee, empNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}