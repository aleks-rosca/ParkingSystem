package DB;

import model.Employee;

public interface IEmpDAO {
    String  addEmployee(Employee employee);
    boolean checkEmployeeByEmpNumber(String empnumber);
    Employee getEmployeeByName(String firstName,String lastName);
}
