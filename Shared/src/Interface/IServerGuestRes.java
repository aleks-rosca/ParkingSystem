package Interface;

import model.GuestRes;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServerGuestRes extends Remote {
    void message(String msg) throws RemoteException;
    String addGuestRes(GuestRes guestRes) throws RemoteException;

    String cancelGuestRes(String resNo) throws RemoteException;

    List<GuestRes> getAllGuestReservation() throws RemoteException;
}
