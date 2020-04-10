package ManagerClient;

import Interface.IServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ManagerClient implements IManagerClient {
    private IServer sInterfaceM;

    public ManagerClient() throws RemoteException, NotBoundException, MalformedURLException {
        sInterfaceM = (IServer) Naming.lookup("rmi://localhost:1099/IPMS");
        sInterfaceM.message("Manager Connected");
    }

    public IManagerClientE getClientE() {
        return new ManagerClientE(sInterfaceM);

    }

    public IManagerClientG getClientG() {
        return new ManagerClientG(sInterfaceM);
    }

    public IManagerClientS getClientS() {
        return new ManagerClientS(sInterfaceM);
    }
}