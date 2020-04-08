package Server;

import Interface.IServerGC;
import Interface.IServerMC;
import Model.*;
import model.Employee;
import model.EmployeeRes;
import model.GuestRes;
import model.Status;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Server extends UnicastRemoteObject implements IServerMC, IServerGC {
    private ISModelE modelMc;
    private ISModelG modelGc;
    private ISModelU modelU;
    private ISModelS modelS;


    public Server() throws RemoteException {
        modelMc = new SModelE();
        modelGc = new SModelG();
        modelU = new SModelU();
        modelS = new SModelS();

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
        return modelU.addGuestRes(guestRes);
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
        return modelU.cancelGuestRes(resNo);
    }

    @Override
    public List<GuestRes> getAllGuestReservation() {
        return modelU.getAllGuestReserevation();
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
        return modelS.getParkingStatus();
    }

    @Override
    public List<Status> getAllStatuses() {
        return modelS.getAllStatuses();
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
        return modelS.getNumberOfGuestsInParkingLot();
    }

    @Override
    public int getNumberOfEmployeesInParkingLot() {
        return modelS.getNumberOfEmployeesInParkingLot();
    }

    @Override
    public int getNumberOfPublicUsersInParkingLot() {
        return modelS.getNumberOfPublicUsersInParkingLot();
    }

}

