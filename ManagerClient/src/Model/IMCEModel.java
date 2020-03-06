package Model;

import java.rmi.RemoteException;

public interface IMCEModel {
    public void createEmp(String empName, String empNum) throws RemoteException;
    public void addEmpRes(String dateFromPicker, String empNum) throws RemoteException;
}
