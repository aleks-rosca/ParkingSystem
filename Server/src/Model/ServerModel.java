package Model;

import DB.*;
import model.Employee;
import model.EmployeeRes;
import model.GuestRes;
import model.Status;

import java.util.List;
import java.util.Random;

public class ServerModel implements IServerModel {
    private Random random;
    private IEmpDAO empdb;
    private IEmpResDAO empResDAO;
    private IEmpCheckDAO empcheck;
    private IGuestResDAO guestResDAO;
    private IGuestCheckDAO guestCheckDAO;
    private IStatusDAO statusDAO;
    private IPublicDAO publicDAO;


    public ServerModel() {
        empdb = new EmpDAO();
        empResDAO = new EmpResDAO();
        empcheck = new EmpCheckDAO();
        guestResDAO = new GuestResDAO();
        guestCheckDAO = new GuestCheckDAO();
        random = new Random();
        statusDAO = new StatusDAO();
        publicDAO = new PublicDAO();
    }

    public String addEmployee(Employee employee) {
        return empdb.addEmployee(employee);
    }

    public String addEmpRes(EmployeeRes employeeRes) {
        return empResDAO.addReservetion(employeeRes);
    }

    @Override
    public String empCheckIn(String empNo) {
        return empcheck.empCheckIn(empNo);
    }

    @Override
    public String empCheckOut(String empNo) {
        return empcheck.empCheckOut(empNo);
    }

    @Override
    public String addGuestRes(GuestRes guestRes) {
        guestRes.setResNo("G" + Integer.toString(random.nextInt((9999 - 1001) + 1) + 99));
        return guestResDAO.addGuestRes(guestRes) + " " + guestRes.getResNo();
    }

    @Override
    public String guestCheckIn(String resNo) {
        return guestCheckDAO.guestCheckIn(resNo);
    }

    @Override
    public String guestCheckOut(String resNo) {
        return guestCheckDAO.guestCheckOut(resNo);
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
    public String getEmployeeNameByEmpNo(String empNo) {
        return empdb.getEmployeeNameByEmpNo(empNo);
    }


    @Override
    public  String deleteEmployee(Employee employee){return empdb.deleteEmployee(employee);}

    @Override
    public String updateEmployee(Employee newEmployee, String empNo) {
        return empdb.updateEmployee(newEmployee,empNo);
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
    public String publicUserIn(String licencePlate) {
        return publicDAO.PublicCheckIn(licencePlate);
    }

    @Override
    public String publicUserOut(String licencePlate) {
        return publicDAO.PublicCheckOut(licencePlate);
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

