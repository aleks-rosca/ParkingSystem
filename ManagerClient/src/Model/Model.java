package Model;


import ManagerClient.Client;
import ManagerClient.IClient;
import model.Employee;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Model {
    private IClient client;
    public Model() throws RemoteException, NotBoundException, MalformedURLException {
        client = new Client();
    }
    public void createEmp(String empName, String empNum) throws RemoteException {
        Employee emp = new Employee(empName, empNum);
        client.addEmployee(emp);
    }
}
