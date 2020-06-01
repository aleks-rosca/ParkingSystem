package ManagerClient;

import Interface.IServer;
import model.GuestRes;

import java.rmi.RemoteException;
import java.util.List;

public class ManagerClientG implements IManagerClientG{
    private final IServer sInterfaceM;
    public ManagerClientG(IServer s){
        sInterfaceM = s;
    }
    @Override
    public String addGuestRes(GuestRes guestRes) {
        try {
            return sInterfaceM.getServerGuestRes().addGuestRes(guestRes);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public String cancelGuestRes(String resNo) {
        try {
            return sInterfaceM.getServerGuestRes().cancelGuestRes(resNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @Override
    public List<GuestRes> getAllGuestReservation() {
        try {
            return sInterfaceM.getServerGuestRes().getAllGuestReservation();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
