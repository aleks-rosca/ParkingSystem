package EmployeeClient;

import model.EmployeeRes;
import Interface.IServerMC;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class EmployeeClient implements IEmployeeClient {
    private IServerMC sInterfaceM;
   public EmployeeClient() throws RemoteException, NotBoundException, MalformedURLException {
       sInterfaceM = (IServerMC) Naming.lookup("rmi://localhost:1099/IPMS");
       sInterfaceM.message("Employee Connected");
   }
    @Override
    public String addReservationByEmp(EmployeeRes employeeRes) {
       try {
           return sInterfaceM.addEmpRes(employeeRes);
       } catch (RemoteException e) {
           e.printStackTrace();
           return "Error";
       }

    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        try {
            return sInterfaceM.deleteEmpRes(employeeRes);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @Override
    public List<EmployeeRes> getEmpRes(String empNo) {
        try {
            return sInterfaceM.getEmpResByEmpNo(empNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }

    }
}
