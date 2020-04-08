package Interface;

import model.Status;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServerStatus extends Remote {
    void message(String msg) throws RemoteException;
    int getParkingStatus() throws RemoteException;

    List<Status> getAllStatuses() throws RemoteException;

    int getNumberOfGuestsInParkingLot() throws RemoteException;

    int getNumberOfEmployeesInParkingLot() throws RemoteException;

    int getNumberOfPublicUsersInParkingLot() throws RemoteException;
}
