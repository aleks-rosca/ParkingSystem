package Server;

import Interface.IServerGuestRes;
import Model.ISModelU;
import Model.SModelU;
import model.GuestRes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServerGuestRes implements IServerGuestRes {
    private ISModelU modelU;

    public ServerGuestRes() throws RemoteException {
        modelU = new SModelU();
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void message(String msg) throws RemoteException {
        System.out.println(msg);
    }

    @Override
    public String addGuestRes(GuestRes guestRes) {
        return modelU.addGuestRes(guestRes);
    }
    @Override
    public String cancelGuestRes(String resNo) {
        return modelU.cancelGuestRes(resNo);
    }

    @Override
    public List<GuestRes> getAllGuestReservation() {
        return modelU.getAllGuestReserevation();
    }

}
