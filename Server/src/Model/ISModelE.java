package Model;

import model.Employee;
import model.EmployeeRes;

import java.util.List;

public interface ISModelE {
    String addEmployee(Employee employee);

    String addEmpRes(EmployeeRes employeeRes);

    List<EmployeeRes> getEmpResByEmpNo(String empNo);

    String deleteEmpRes(EmployeeRes employeeRes);

    List<EmployeeRes> getAllEmpReservation();

    List<Employee> getAllEmployee();

    String deleteEmployee(Employee employee);

    String updateEmployee(Employee newEmployee, String empNo);




}
