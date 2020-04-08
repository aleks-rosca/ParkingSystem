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

    String addGuestRes(GuestRes guestRes);

    String cancelGuestRes(String resNo);

    List<GuestRes> getAllGuestReservation();

    List<Status> getAllStatues();

    int getCurrentStatus();

    int getNumberOfGuestsInParkingLot();

    int getNumberOfEmployeesInParkingLot();

    int getNumberOfPublicUsersInParkingLot();

}
