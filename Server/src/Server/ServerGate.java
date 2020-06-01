package Server;

import Interface.IServerGC;
import Model.ISModelG;
import Model.ISModelS;
import Model.SModelG;
import Model.SModelS;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerGate implements IServerGC {
    private final ISModelG modelGc;
    private final ISModelS modelS;

    public ServerGate() throws RemoteException {
        modelGc = new SModelG();
        modelS = new SModelS();
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public String guestCheckIn(String resNo) {
        return modelGc.guestCheckIn(resNo);
    }

    @Override
    public String guestCheckOut(String resNo) {
        return modelGc.guestCheckOut(resNo);
    }

    @Override
    public int getParkingStatus() throws RemoteException {
        return modelS.getParkingStatus();
    }

    @Override
    public void message(String msg) throws RemoteException {

    }

    @Override
    public String empCheckIn(String empNo) {
        return modelGc.empCheckIn(empNo);
    }

    @Override
    public String empCheckOut(String empNo) {
        return modelGc.empCheckOut(empNo);
    }

    @Override
    public String publicUserIn(String licencePlate) {
        return modelGc.publicUserIn(licencePlate);
    }

    @Override
    public String publicUserOut(String plate) {
        return modelGc.publicUserOut(plate);
    }
}
