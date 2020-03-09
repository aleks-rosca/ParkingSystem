package ManagerClient;

import model.Employee;
import model.EmployeeRes;

public interface IManagerClient {
    String addEmployee(Employee employee);

    String addEmployeeRes(EmployeeRes employeeRes);
}
