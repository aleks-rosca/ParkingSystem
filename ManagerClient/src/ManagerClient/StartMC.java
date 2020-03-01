package ManagerClient;

import Controller.MCController;
import serverinterface.IServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartMC {


    public static void main(String[] args) throws RemoteException, NotBoundException {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            IServer s = (IServer) reg.lookup("IPMS");
            MCController c = new MCController(s);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

}

