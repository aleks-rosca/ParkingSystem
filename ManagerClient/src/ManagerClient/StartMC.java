package ManagerClient;

import serverinterface.IServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartMC {



    public StartMC() throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        IServer s  = (IServer)reg.lookup("IPMS");

    }
    public void sendToServer(String msg){
        try{
            msg = "Client";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        new StartMC();
        System.out.println("Connected");
    }

}
