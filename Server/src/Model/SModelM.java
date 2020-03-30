package Model;

import DB.*;
import model.Employee;
import model.EmployeeRes;
import model.GuestRes;

import java.util.List;
import java.util.Random;

public class SModelM implements ISModelM {
    private Random random;
    private IEmpDAO empdb;
    private IEmpResDAO empResDAO;
    private IGuestResDAO guestResDAO;


    public SModelM() {
        empdb = new EmpDAO();
        empResDAO = new EmpResDAO();
        guestResDAO = new GuestResDAO();
        random = new Random();
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




}

