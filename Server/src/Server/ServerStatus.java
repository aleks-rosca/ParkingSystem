package Server;

import Interface.IServerStatus;
import Model.ISModelS;
import Model.SModelS;
import model.Status;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServerStatus implements IServerStatus {
    private final ISModelS modelS;

    public ServerStatus() throws RemoteException {

        modelS = new SModelS();
        UnicastRemoteObject.exportObject(this, 0);

    }
    @Override
    public void message(String msg) throws RemoteException {
        System.out.println(msg);
    }

    @Override
    public int getParkingStatus() {
        return modelS.getParkingStatus();
    }

    @Override
    public List<Status> getAllStatuses() {
        return modelS.getAllStatuses();
    }


    @Override
    public int getNumberOfGuestsInParkingLot() {
        return modelS.getNumberOfGuestsInParkingLot();
    }

    @Override
    public int getNumberOfEmployeesInParkingLot() {
        return modelS.getNumberOfEmployeesInParkingLot();
    }

    @Override
    public int getNumberOfPublicUsersInParkingLot() {
        return modelS.getNumberOfPublicUsersInParkingLot();
    }

}
