package Model;

import ManagerClient.Client;
import ManagerClient.IClient;
import model.Employee;
import model.EmployeeRes;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Model {
    private IClient client;
    Employee employee;
    EmployeeRes employeeRes;
    public Model() throws RemoteException, NotBoundException, MalformedURLException {
        client = new Client();

    }
    public void createEmp(String empName, String empNum) throws RemoteException {
        employee = new Employee(empName, empNum);
        client.addEmployee(employee);
    }
    public void addEmpRes(String dateFromPicker, String empNum) throws RemoteException {
        employeeRes = new EmployeeRes(dateFromPicker, empNum);
        client.addEmployeeRes(employeeRes);
    }
}
