package Model;

import javafx.collections.ObservableList;
import model.EmployeeRes;

import java.rmi.RemoteException;

public interface IMCEModel {
    String createEmp(String empFName, String empLName, String empNum) throws RemoteException;

    String addEmpRes(String dateFromPicker, String empNum) throws RemoteException;

    boolean checkFirstChar(String empNo);

    ObservableList<EmployeeRes> getAllEmpReservation();
    ObservableList<EmployeeRes> getAllEmpReservationByEmpNo(String empNo);
    String deleteEmpRes(EmployeeRes employeeRes);

    String rearrangeChars(String empName);
}
