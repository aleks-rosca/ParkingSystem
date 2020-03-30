package Model;

import model.Employee;
import model.EmployeeRes;
import model.GuestRes;

import java.util.List;

public interface ISModelM {
    String addEmployee(Employee employee);

    String addEmpRes(EmployeeRes employeeRes);

    String addGuestRes(GuestRes guestRes);

    List<EmployeeRes> getEmpResByEmpNo(String empNo);

    String deleteEmpRes(EmployeeRes employeeRes);

    List<EmployeeRes> getAllEmpReservation();

    String cancelGuestRes(String resNo);

    List<GuestRes> getAllGuestReserevation();

    List<Employee> getAllEmployee();

    String deleteEmployee(Employee employee);

    String updateEmployee(Employee newEmployee, String empNo);




}
