package ManagerClient;

import model.Employee;
import model.EmployeeRes;

import java.util.List;

public interface IManagerClientE {
    String addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    String addEmployeeRes(EmployeeRes employeeRes);

    List<EmployeeRes> getAllReservationByEmpNo(String empNo);

    List<EmployeeRes> getAllEmpReservations();

    String deleteEmpRes(EmployeeRes employeeRes);

    String deleteEmployee(Employee employee);

    String updateEmployee(Employee newEmployee, String empNo);

}
