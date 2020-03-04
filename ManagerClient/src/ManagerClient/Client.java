package ManagerClient;
import model.Employee;
import serverinterface.IServer;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client implements IClient {
    private IServer serverinterface;

    public Client () throws RemoteException, NotBoundException, MalformedURLException {
        serverinterface = (IServer) Naming.lookup("rmi://localhost:1099/IPMS");
        serverinterface.message("Manager Connected");
    }

    @Override
    public void addEmployee(Employee employee) throws RemoteException {
        serverinterface.addEmployee(employee);
    }
}