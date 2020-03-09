package Model;

import ManagerClient.IManagerClient;
import model.Employee;
import model.EmployeeRes;

public class MCEModel implements IMCEModel {

    Employee employee;
    EmployeeRes employeeRes;
    private IManagerClient client;

    public MCEModel(IManagerClient cl) {
        client = cl;

    }

    public String createEmp(String empName, String empNum) {
        employee = new Employee(empName, empNum);
        return client.addEmployee(employee);

    }

    public String addEmpRes(String dateFromPicker, String empNum) {
        employeeRes = new EmployeeRes(dateFromPicker, empNum);
        return client.addEmployeeRes(employeeRes);
    }

    public boolean checkFirstChar(String empNo) {

        return 'E' == empNo.charAt(0);

    }

    public String rearrangeChars(String empName){
        empName = empName.substring(0,1).toUpperCase() + empName.substring(1).toLowerCase();
        return empName;
    }
}
