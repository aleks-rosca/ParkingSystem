package Model;


import javafx.collections.ObservableList;
import model.GuestRes;

import java.rmi.RemoteException;

public interface IMCGModel {
    String addGuestRes(String name, String purpose, String date) throws RemoteException;
    ObservableList<GuestRes> allGuestReservations();

    String cancelGuestReservation(String resNo);

}
