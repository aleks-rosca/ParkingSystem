package Model;

import ManagerClient.IManagerClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Employee;
import model.EmployeeRes;

public class MCEModel implements IMCEModel {

    Employee employee;
    EmployeeRes employeeRes;
    private IManagerClient client;

    public MCEModel(IManagerClient cl) {
        client = cl;

    }

    //empty constructor for testing
    public MCEModel() {
    }

    @Override
    public String createEmp(String empFName, String empLName, String empNum) {
        employee = new Employee(empFName, empLName, empNum);
        return client.addEmployee(employee);

    }
    @Override
    public String addEmpRes(String dateFromPicker, String empNum) {
        employeeRes = new EmployeeRes(dateFromPicker, empNum);
        return client.addEmployeeRes(employeeRes);
    }

    public boolean checkFirstChar(String empNo) {
        if ('E' == empNo.charAt(0)) {
            return true;
        } else return false;
    }

    @Override
    public ObservableList<EmployeeRes> getAllEmpReservation() {
        ObservableList<EmployeeRes> empreslist;

        empreslist = FXCollections.observableArrayList(client.getAllEmpReservations());

        return empreslist;
    }

    @Override
    public ObservableList<EmployeeRes> getAllEmpReservationByEmpNo(String empNo) {
        ObservableList<EmployeeRes> empreslist;

        empreslist = FXCollections.observableArrayList(client.getAllReservationByEmpNo(empNo));

        return empreslist;
    }

    @Override
    public ObservableList<Employee> getAllEmployee() {
        ObservableList<Employee> employeeList = FXCollections.observableArrayList(client.getAllEmployee());

        return employeeList;


    }

    @Override
    public String getEmployeeNameByEmpNo(String empNo) {
        return client.getEmployeeNameByEmpNo(empNo);
    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        return client.deleteEmpRes(employeeRes);
    }

    public String rearrangeChars(String empName) {
        empName = empName.substring(0, 1).toUpperCase() + empName.substring(1).toLowerCase();
        return empName;
    }

    @Override
    public String deleteEmployee(Employee employee) {
        return client.deleteEmployee(employee);
    }

    @Override
    public String updateEmployee(Employee newEmployee, String empNo) {
        return client.updateEmployee(newEmployee, empNo);
    }

}
