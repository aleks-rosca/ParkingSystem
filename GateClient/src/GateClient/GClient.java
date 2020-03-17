package GateClient;

import serverinterface.IServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class GClient implements IGClient {
    private IServer serverinterface;

    public GClient() throws RemoteException, MalformedURLException, NotBoundException {
        serverinterface = (IServer) Naming.lookup("rmi://localhost:1099/IPMS");
        serverinterface.message("Gate IN client connected");
    }

    @Override
    public String empCheckIn(String empNo) {
        try {
            return serverinterface.empCheckIn(empNo);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public String guestCheckin(String resNo) {
        try {
            return serverinterface.guestCheckIn(resNo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }
}
