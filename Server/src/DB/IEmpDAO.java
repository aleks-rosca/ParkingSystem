package DB;

import model.Employee;

import java.util.List;

public interface IEmpDAO {
    String addEmployee(Employee employee);

    boolean checkEmployeeByEmpNumber(String empnumber);

    Employee getEmployeeByName(String firstName, String lastName);

    String getEmployeeNameByEmpNo(String empNo);

    List<Employee> getAllEmployees();

    String deleteEmployee(Employee employee);

    String updateEmployee(Employee newEmployee, String empNo);
}
