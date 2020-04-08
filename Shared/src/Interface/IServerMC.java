package Interface;

import model.Employee;
import model.EmployeeRes;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServerMC extends Remote, Serializable {

    void message(String msg) throws RemoteException;

    String addEmployee(Employee employee) throws RemoteException;

    String addEmpRes(EmployeeRes employeeRes) throws RemoteException;


    List<EmployeeRes> getEmpResByEmpNo(String empNo) throws RemoteException;

    List<EmployeeRes> getAllEmpReservations() throws RemoteException;

    String deleteEmpRes(EmployeeRes employeeRes) throws RemoteException;


    List<Employee> getAllEmployees() throws RemoteException;

    String deleteEmployee(Employee employee) throws RemoteException;

    String updateEmployee(Employee newEmployee, String empNo) throws RemoteException;


}
