package Interface;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServerGC extends Remote, Serializable {

    void message(String msg) throws RemoteException;

    String empCheckIn(String empNo) throws RemoteException;

    String empCheckOut(String empNo) throws RemoteException;

    String guestCheckIn(String resNo) throws RemoteException;

    String guestCheckOut(String resNo) throws RemoteException;

    int getParkingStatus() throws RemoteException;

    String publicUserIn(String licencePlate) throws RemoteException;

    String publicUserOut(String licencePlate) throws RemoteException;


}
