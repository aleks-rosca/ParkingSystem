package Model;

import java.rmi.RemoteException;

public interface IMCEModel {
    String createEmp(String empFName,String empLName, String empNum) throws RemoteException;

    String addEmpRes(String dateFromPicker, String empNum) throws RemoteException;

    boolean checkFirstChar(String empNo);

    String rearrangeChars(String empName);
}
