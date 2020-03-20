package serverinterface;


import model.Employee;
import model.EmployeeRes;
import model.GuestRes;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServer extends Remote, Serializable {
    void message(String msg) throws RemoteException;

    String addEmployee(Employee employee) throws RemoteException;

    String addEmpRes(EmployeeRes employeeRes) throws RemoteException;

    String empCheckIn(String empNo) throws RemoteException;

    String empCheckOut(String empNo) throws RemoteException;

    String addGuestRes(GuestRes guestRes) throws RemoteException;

    String guestCheckIn(String resNo) throws RemoteException;

    String guestCheckOut(String resNo) throws RemoteException;

    List<EmployeeRes> getEmpResByEmpNo(String empNo) throws RemoteException;

    List<EmployeeRes> getAllEmpReservations() throws RemoteException;

    String deleteEmpRes(EmployeeRes employeeRes) throws RemoteException;

    String cancelGuestRes(String resNo) throws RemoteException;

    List<GuestRes> getAllGuestReserevation() throws RemoteException;

    String getEmployeeNameByEmpNo(String empNo) throws RemoteException;

    List<Employee> getAllEmployees() throws RemoteException;
}
