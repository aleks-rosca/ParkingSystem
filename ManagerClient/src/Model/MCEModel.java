package Model;

import ManagerClient.IClient;
import model.Employee;
import model.EmployeeRes;

public class MCEModel implements IMCEModel {

    Employee employee;
    EmployeeRes employeeRes;
    private IClient client;

    public MCEModel(IClient cl) {
        client = cl;

    }

    public String createEmp(String empName, String empNum) {
        employee = new Employee(empName, empNum);
        return client.addEmployee(employee);

    }

    public void addEmpRes(String dateFromPicker, String empNum) {
        employeeRes = new EmployeeRes(dateFromPicker, empNum);
        client.addEmployeeRes(employeeRes);
    }

    public boolean checkFirstChar(String empNo){

        if('E'==empNo.charAt(0)){
            return true;
        }else {
            return false;
        }

    }
}
