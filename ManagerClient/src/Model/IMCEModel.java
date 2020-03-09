package Model;

import java.rmi.RemoteException;

public interface IMCEModel {
    String createEmp(String empName, String empNum) throws RemoteException;

    String addEmpRes(String dateFromPicker, String empNum) throws RemoteException;

    boolean checkFirstChar(String empNo);

    String rearrangeChars(String empName);
}
