package Model;

import DB.*;
import model.Employee;
import model.EmployeeRes;
import model.GuestRes;

import java.util.Random;

public class ServerModel implements IServerModel{
    private Random random;
    private IEmpDAO empdb;
    private IEmpResDAO empResDAO;
    private IEmpCheckDAO empcheck;
    private IGuestResDAO guestResDAO;


    public ServerModel() {
        empdb = new EmpDAO();
        empResDAO = new EmpResDAO();
        empcheck = new EmpCheckDAO();
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
    public String empCheckIn(String empNo) {
        return empcheck.empCheckIn(empNo);
    }

    @Override
    public String empCheckOut(String empNo) {
        return empcheck.empCheckOut(empNo);
    }

    @Override
    public String addGuestRes(GuestRes guestRes) {
        guestRes.setResNo("G"+Integer.toString(random.nextInt((9999-100)+1)+10));
        return guestResDAO.addGuestRes(guestRes)+" "+guestRes.getResNo() ;
    }

}
