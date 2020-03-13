package Model;

import DB.*;
import model.Employee;
import model.EmployeeRes;

public class ServerModel implements IServerModel{
    private IEmpDAO empdb;
    private IEmpResDAO empResDAO;
    private EmpCheckDAO empcheck;


    public ServerModel() {
        empdb = new EmpDAO();
        empResDAO = new EmpResDAO();
        empcheck = new EmpCheckDAO();

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

}
