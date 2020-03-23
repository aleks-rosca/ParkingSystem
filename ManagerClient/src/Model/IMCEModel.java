package Model;

import javafx.collections.ObservableList;
import model.Employee;
import model.EmployeeRes;

public interface IMCEModel {
    String createEmp(String empFName, String empLName, String empNum);

    String addEmpRes(String dateFromPicker, String empNum);

    boolean checkFirstChar(String empNo);

    ObservableList<EmployeeRes> getAllEmpReservation();

    ObservableList<EmployeeRes> getAllEmpReservationByEmpNo(String empNo);

    ObservableList<Employee> getAllEmployee();

    String getEmployeeNameByEmpNo(String empNo);

    String deleteEmpRes(EmployeeRes employeeRes);

    String rearrangeChars(String empName);

    String deleteEmployee(Employee employee);

    String updateEmployee(Employee newEmployee, String empNo);
}
