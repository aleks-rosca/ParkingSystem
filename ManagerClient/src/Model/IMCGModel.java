package Model;


import java.rmi.RemoteException;

public interface IMCGModel {
    String addGuestRes(String name, String purpose, String date) throws RemoteException;
}
