package Model;

import java.rmi.RemoteException;

public interface IECModel {
   public String addEmpRes(String dateFromPicker, String empNo) throws RemoteException;

}
