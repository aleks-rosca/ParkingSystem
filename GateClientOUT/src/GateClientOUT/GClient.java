package GateClientOUT;

import Interface.IServerGC;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class GClient implements IGClient {
    private IServerGC sInterfaceG;

    public GClient() throws RemoteException, MalformedURLException, NotBoundException {
        sInterfaceG = (IServerGC) Naming.lookup("rmi://localhost:1099/IPMS");
        sInterfaceG.message("Gate OUT client connected");
    }

    @Override
    public String empCheckOut(String empNo) {
        try {
            return sInterfaceG.empCheckOut(empNo);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public String guestCheckOut(String resNo) {
        try {
            return sInterfaceG.guestCheckOut(resNo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public String publicCheckOut(String plate) {
        try {
            return sInterfaceG.publicUserOut(plate);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }
}
