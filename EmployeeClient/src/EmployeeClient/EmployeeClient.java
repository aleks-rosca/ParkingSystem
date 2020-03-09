package EmployeeClient;

import model.EmployeeRes;
import serverinterface.IServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class EmployeeClient implements IEmployeeClient {
    private IServer serverinterface;
   public EmployeeClient() throws RemoteException, NotBoundException, MalformedURLException {
       serverinterface = (IServer) Naming.lookup("rmi://localhost:1099/IPMS");
       serverinterface.message("Employee Connected");
   }
    @Override
    public String addReservationByEmp(EmployeeRes employeeRes) {
       try {
           return serverinterface.addEmpRes(employeeRes);
       } catch (RemoteException e) {
           e.printStackTrace();
           return "Error";
       }

    }
}
