package DB;

import model.Employee;
import model.EmployeeRes;

public interface IEmpDAO {
    boolean  addEmployee(Employee employee);
    boolean getEmployeeByEmpNumber(String empnumber);
    Employee getEmployeeByName(String name);
    void addReservetion(Employee employee, EmployeeRes employeeRes);
}
