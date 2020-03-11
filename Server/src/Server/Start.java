package Server;

import serverinterface.IServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Start {
    public static void main(String[] args) {
        try {
            IServer s = new Server();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.bind("IPMS", s);
            System.out.println("Server Started");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
