package ManagerClient;

import model.Employee;
import model.EmployeeRes;
import model.GuestRes;

import java.util.List;

public interface IManagerClient {
    String addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    String getEmployeeNameByEmpNo(String empNo);

    String addEmployeeRes(EmployeeRes employeeRes);

    List<EmployeeRes> getAllReservationByEmpNo(String empNo);

    List<EmployeeRes> getAllEmpReservations();

    String deleteEmpRes(EmployeeRes employeeRes);



    // for managing Guests Reservations
    String addGuestRes(GuestRes guestRes);
    String cancelGuestRes(String resNo);

    List<GuestRes> getAllGuestReserevation();


}
