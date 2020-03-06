package Model;

import model.Employee;
import model.EmployeeRes;

public interface IServerModel {
    public String addEmployee(Employee employee);
    public String addEmpRes(EmployeeRes employeeRes);
}
