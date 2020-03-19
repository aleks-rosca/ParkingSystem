package Model;

import DB.*;
import model.Employee;
import model.EmployeeRes;
import model.GuestRes;

import java.util.List;
import java.util.Random;

public class ServerModel implements IServerModel {
    private Random random;
    private IEmpDAO empdb;
    private IEmpResDAO empResDAO;
    private IEmpCheckDAO empcheck;
    private IGuestResDAO guestResDAO;
    private IGuestCheckDAO guestCheckDAO;


    public ServerModel() {
        empdb = new EmpDAO();
        empResDAO = new EmpResDAO();
        empcheck = new EmpCheckDAO();
        guestResDAO = new GuestResDAO();
        guestCheckDAO = new GuestCheckDAO();
        random = new Random();
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
        guestRes.setResNo("G" + Integer.toString(random.nextInt((9999 - 1000) + 1) + 10));
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
    public List<EmployeeRes> getEmpRes(String empNo) {
        return empResDAO.reservationsByEmpNo(empNo);
    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        return empResDAO.cancelReservation(employeeRes);
    }

    @Override
    public String cancelGuestRes(String resNo) {
        return guestResDAO.cancelGuestRes(resNo);
    }

    @Override
    public List<GuestRes> getAllGuestReserevation() {
        return guestResDAO.getAllGuestReserevation();
    }
}

