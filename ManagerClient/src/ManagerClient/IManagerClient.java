package ManagerClient;

import model.Employee;
import model.EmployeeRes;

public interface IManagerClient {
    public String addEmployee(Employee employee);
    public void addEmployeeRes(EmployeeRes employeeRes);
}
