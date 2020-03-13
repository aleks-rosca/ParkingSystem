package ManagerClient;

import model.Employee;
import model.EmployeeRes;
import model.GuestRes;

public interface IManagerClient {
    String addEmployee(Employee employee);

    String addEmployeeRes(EmployeeRes employeeRes);

    String addGuestRes(GuestRes guestRes);
}
