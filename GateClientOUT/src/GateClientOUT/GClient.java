package GateClientOUT;

import serverinterface.IServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class GClient implements IGClient {
    private IServer serverinterface;

    public GClient() throws RemoteException, MalformedURLException, NotBoundException {
        serverinterface = (IServer) Naming.lookup("rmi://localhost:1099/IPMS");
        serverinterface.message("Gate OUT client connected");
    }

    @Override
    public String empCheckOut(String empNo) {
        try {
            return serverinterface.empCheckOut(empNo);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public String guestCheckOut(String resNo) {
        try {
            return serverinterface.guestCheckOut(resNo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }
}
