package DB;

import model.Employee;

import java.util.List;

public interface IEmpDAO {
    String addEmployee(Employee employee);

    boolean checkEmployeeByEmpNumber(String empnumber);





    List<Employee> getAllEmployees();

    String deleteEmployee(Employee employee);

    String updateEmployee(Employee newEmployee, String empNo);
}
