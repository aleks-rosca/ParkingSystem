package Model;

import model.Employee;
import model.EmployeeRes;

public interface IServerModel {
    String addEmployee(Employee employee);

    String addEmpRes(EmployeeRes employeeRes);
}