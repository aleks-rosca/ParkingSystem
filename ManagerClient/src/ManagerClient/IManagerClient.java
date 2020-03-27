package ManagerClient;

import model.Employee;
import model.EmployeeRes;
import model.GuestRes;
import model.Status;

import java.util.List;

public interface IManagerClient {
    String addEmployee(Employee employee);

    List<Employee> getAllEmployee();



    String addEmployeeRes(EmployeeRes employeeRes);

    List<EmployeeRes> getAllReservationByEmpNo(String empNo);

    List<EmployeeRes> getAllEmpReservations();

    String deleteEmpRes(EmployeeRes employeeRes);

    String deleteEmployee(Employee employee);

    String updateEmployee(Employee newEmployee, String empNo);

    // for managing Guests Reservations
    String addGuestRes(GuestRes guestRes);

    String cancelGuestRes(String resNo);

    List<GuestRes> getAllGuestReserevation();

    List<Status> getAllStatues();

    int getCurrentStatus();

    int getNumberOfGuestsInParkingLot();

    int getNumberOfEmployeesInParkingLot();

    int getNumberOfPublicUsersInParkingLot();


}
