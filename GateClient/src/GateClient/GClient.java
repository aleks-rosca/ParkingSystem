package GateClient;

import Interface.IServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class GClient implements IGClient {
    private IServer sInterfaceG;

    public GClient() throws RemoteException, MalformedURLException, NotBoundException {
        sInterfaceG = (IServer) Naming.lookup("rmi://localhost:1099/IPMS");
        sInterfaceG.message("Gate IN client connected");
    }

    @Override
    public String empCheckIn(String empNo) {
        try {
            return sInterfaceG.getGateServer().empCheckIn(empNo);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public String guestCheckin(String resNo) {
        try {
            return sInterfaceG.getGateServer().guestCheckIn(resNo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public int getParkingStatus() {
        try {
            return sInterfaceG.getGateServer().getParkingStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String publicUserIn(String licencePlate) {
        try {
            return sInterfaceG.getGateServer().publicUserIn(licencePlate);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }

}
