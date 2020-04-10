package ManagerClient;

import Interface.IServer;
import model.Status;

import java.rmi.RemoteException;
import java.util.List;

public class ManagerClientS implements IManagerClientS {
    private IServer sInterfaceM;
    public ManagerClientS(IServer s){
        sInterfaceM = s;
    }

    @Override
    public List<Status> getAllStatues() {
        try {
            return sInterfaceM.getServerStatus().getAllStatuses();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getCurrentStatus() {
        try {

            return sInterfaceM.getServerStatus().getParkingStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getNumberOfGuestsInParkingLot() {
        try {
            return sInterfaceM.getServerStatus().getNumberOfGuestsInParkingLot();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getNumberOfEmployeesInParkingLot() {
        try {
            return sInterfaceM.getServerStatus().getNumberOfEmployeesInParkingLot();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getNumberOfPublicUsersInParkingLot() {
        try {
            return sInterfaceM.getServerStatus().getNumberOfPublicUsersInParkingLot();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
