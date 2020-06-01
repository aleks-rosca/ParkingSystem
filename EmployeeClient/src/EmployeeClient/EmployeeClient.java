package EmployeeClient;

import Interface.IServer;
import model.EmployeeRes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class EmployeeClient implements IEmployeeClient {
    private final IServer sInterfaceM;
   public EmployeeClient() throws RemoteException, NotBoundException, MalformedURLException {
       sInterfaceM = (IServer) Naming.lookup("rmi://localhost:1099/IPMS");
       sInterfaceM.message("Employee Connected");
   }
    @Override
    public String addReservationByEmp(EmployeeRes employeeRes) {
       try {
           return sInterfaceM.getEmployeeServer().addEmpRes(employeeRes);
       } catch (RemoteException e) {
           e.printStackTrace();
           return "Error";
       }

    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        try {
            return sInterfaceM.getEmployeeServer().deleteEmpRes(employeeRes);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @Override
    public List<EmployeeRes> getEmpRes(String empNo) {
        try {
            return sInterfaceM.getEmployeeServer().getEmpResByEmpNo(empNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }

    }
}
