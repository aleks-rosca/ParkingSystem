package ManagerClient;

import model.Employee;
import model.EmployeeRes;
import model.GuestRes;

import java.util.List;

public interface IManagerClient {
    String addEmployee(Employee employee);

    String addEmployeeRes(EmployeeRes employeeRes);


    // for managing Guests Reservations
    String addGuestRes(GuestRes guestRes);
    String cancelGuestRes(String resNo);

    List<GuestRes> getAllGuestReserevation();
}
