package Model;

import java.rmi.RemoteException;

public interface IMCEModel {
    public String createEmp(String empName, String empNum) throws RemoteException;
    public void addEmpRes(String dateFromPicker, String empNum) throws RemoteException;
    public boolean checkFirstChar(String empNo);
    public String rearrangeChars(String empName);
}
