package Model;

import DB.EmpDAO;
import DB.EmpResDAO;
import DB.IEmpDAO;
import DB.IEmpResDAO;
import model.Employee;
import model.EmployeeRes;

public class ServerModel implements IServerModel{
    private IEmpDAO empdb;
    private IEmpResDAO empResDAO;


    public ServerModel() {
        empdb = new EmpDAO();
        empResDAO = new EmpResDAO();
    }

    public String addEmployee(Employee employee) {
        return empdb.addEmployee(employee);
    }

    public String addEmpRes(EmployeeRes employeeRes) {
        return empResDAO.addReservetion(employeeRes);
    }

}
