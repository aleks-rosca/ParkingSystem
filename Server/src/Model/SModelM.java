package Model;

import DB.*;
import model.Employee;
import model.EmployeeRes;
import model.GuestRes;
import model.Status;

import java.util.List;
import java.util.Random;

public class SModelM implements ISModelM {
    private Random random;
    private IEmpDAO empdb;
    private IEmpResDAO empResDAO;
    private IGuestResDAO guestResDAO;
    private IStatusDAO statusDAO;


    public SModelM() {
        empdb = new EmpDAO();
        empResDAO = new EmpResDAO();
        guestResDAO = new GuestResDAO();
        random = new Random();
        statusDAO = new StatusDAO();
    }

    public String addEmployee(Employee employee) {
        return empdb.addEmployee(employee);
    }

    public String addEmpRes(EmployeeRes employeeRes) {
        return empResDAO.addReservetion(employeeRes);
    }


    @Override
    public String addGuestRes(GuestRes guestRes) {
        guestRes.setResNo("G" + Integer.toString(random.nextInt((9999 - 1001) + 1) + 99));
        return guestResDAO.addGuestRes(guestRes) + " " + guestRes.getResNo();
    }


    @Override
    public List<EmployeeRes> getEmpResByEmpNo(String empNo) {
        return empResDAO.reservationsByEmpNo(empNo);
    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        return empResDAO.cancelReservation(employeeRes);
    }

    @Override
    public List<EmployeeRes> getAllEmpReservation() {
        return empResDAO.allEmployeeReservations();
    }

    @Override
    public String cancelGuestRes(String resNo) {
        return guestResDAO.cancelGuestRes(resNo);
    }

    @Override
    public List<GuestRes> getAllGuestReserevation() {
        return guestResDAO.getAllGuestReserevation();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return empdb.getAllEmployees();
    }

    @Override
    public String deleteEmployee(Employee employee) {
        return empdb.deleteEmployee(employee);
    }

    @Override
    public String updateEmployee(Employee newEmployee, String empNo) {
        return empdb.updateEmployee(newEmployee, empNo);
    }

    @Override
    public int getParkingStatus() {
        return statusDAO.getCurrentStatus();
    }

    @Override
    public List<Status> getAllStatuses() {
        return statusDAO.getAllStatuses();
    }

    @Override
    public int getNumberOfGuestsInParkingLot() {
        return statusDAO.getNumberOfGuestsInParkingLot();
    }

    @Override
    public int getNumberOfEmployeesInParkingLot() {
        return statusDAO.getNumberOfEmployeesInParkingLot();
    }

    @Override
    public int getNumberOfPublicUsersInParkingLot() {
        return statusDAO.getNumberOfPublicUsersInParkingLot();
    }


}

