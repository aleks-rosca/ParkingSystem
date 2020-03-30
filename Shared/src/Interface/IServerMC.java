package Interface;

import model.Employee;
import model.EmployeeRes;
import model.GuestRes;
import model.Status;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServerMC extends Remote, Serializable {

    void message(String msg) throws RemoteException;

    String addEmployee(Employee employee) throws RemoteException;

    String addEmpRes(EmployeeRes employeeRes) throws RemoteException;

    String addGuestRes(GuestRes guestRes) throws RemoteException;

    List<EmployeeRes> getEmpResByEmpNo(String empNo) throws RemoteException;

    List<EmployeeRes> getAllEmpReservations() throws RemoteException;

    String deleteEmpRes(EmployeeRes employeeRes) throws RemoteException;

    String cancelGuestRes(String resNo) throws RemoteException;

    List<GuestRes> getAllGuestReservation() throws RemoteException;

    List<Employee> getAllEmployees() throws RemoteException;

    String deleteEmployee(Employee employee) throws RemoteException;

    String updateEmployee(Employee newEmployee, String empNo) throws RemoteException;

    int getParkingStatus() throws RemoteException;

    List<Status> getAllStatuses() throws RemoteException;

    int getNumberOfGuestsInParkingLot() throws RemoteException;

    int getNumberOfEmployeesInParkingLot() throws RemoteException;

    int getNumberOfPublicUsersInParkingLot() throws RemoteException;

}
