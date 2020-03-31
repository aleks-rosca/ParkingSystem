package Server;

import Interface.IServerGC;
import Interface.IServerMC;
import Model.ISModelG;
import Model.ISModelM;
import Model.SModelG;
import Model.SModelM;
import model.Employee;
import model.EmployeeRes;
import model.GuestRes;
import model.Status;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Server extends UnicastRemoteObject implements IServerMC, IServerGC {
    private ISModelM modelMc;
    private ISModelG modelGc;


    public Server() throws RemoteException {
        modelMc = new SModelM();
        modelGc = new SModelG();
        // UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void message(String msg) {
        System.out.println(msg);
    }

    @Override
    public String addEmployee(Employee employee) {
        return modelMc.addEmployee(employee);

    }

    @Override
    public String addEmpRes(EmployeeRes employeeRes) {
        return modelMc.addEmpRes(employeeRes);

    }

    @Override
    public String empCheckIn(String empNo) {
        return modelGc.empCheckIn(empNo);
    }

    @Override
    public String empCheckOut(String empNo) {
        return modelGc.empCheckOut(empNo);
    }

    @Override
    public String addGuestRes(GuestRes guestRes) {
        return modelMc.addGuestRes(guestRes);
    }

    @Override
    public String guestCheckIn(String resNo) {
        return modelGc.guestCheckIn(resNo);
    }

    @Override
    public String guestCheckOut(String resNo) {
        return modelGc.guestCheckOut(resNo);
    }

    @Override
    public List<EmployeeRes> getEmpResByEmpNo(String empNo) {
        return modelMc.getEmpResByEmpNo(empNo);
    }

    @Override
    public List<EmployeeRes> getAllEmpReservations() {
        return modelMc.getAllEmpReservation();
    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        return modelMc.deleteEmpRes(employeeRes);
    }

    @Override
    public String cancelGuestRes(String resNo) {
        return modelMc.cancelGuestRes(resNo);
    }

    @Override
    public List<GuestRes> getAllGuestReservation() {
        return modelMc.getAllGuestReserevation();
    }


    @Override
    public List<Employee> getAllEmployees() {
        return modelMc.getAllEmployee();
    }

    @Override
    public String deleteEmployee(Employee employee) {
        return modelMc.deleteEmployee(employee);
    }

    @Override
    public String updateEmployee(Employee newEmployee, String empNo) {
        return modelMc.updateEmployee(newEmployee, empNo);
    }

    @Override
    public int getParkingStatus() {
        return modelMc.getParkingStatus();
    }

    @Override
    public List<Status> getAllStatuses() {
        return modelMc.getAllStatuses();
    }

    @Override
    public String publicUserIn(String licencePlate) {
        return modelGc.publicUserIn(licencePlate);
    }

    @Override
    public String publicUserOut(String plate) {
        return modelGc.publicUserOut(plate);
    }

    @Override
    public int getNumberOfGuestsInParkingLot() {
        return modelMc.getNumberOfGuestsInParkingLot();
    }

    @Override
    public int getNumberOfEmployeesInParkingLot() {
        return modelMc.getNumberOfEmployeesInParkingLot();
    }

    @Override
    public int getNumberOfPublicUsersInParkingLot() {
        return modelMc.getNumberOfPublicUsersInParkingLot();
    }

}

