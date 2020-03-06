package ManagerClient;

import model.Employee;
import model.EmployeeRes;

public interface IClient {
    public String addEmployee(Employee employee);
    public void addEmployeeRes(EmployeeRes employeeRes);
}
