package Model;

import model.EmployeeRes;

import java.rmi.RemoteException;
import java.util.List;

public interface IECModel {
   String addEmpRes(String dateFromPicker, String empNo);
   List<EmployeeRes> getEmpRes(String empNo);

}
