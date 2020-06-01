package Model;

import ManagerClient.IManagerClientG;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.GuestRes;

public class MCGModel implements IMCGModel {

    private final IManagerClientG clientG;
    private GuestRes guestRes;

    public MCGModel(IManagerClientG clg) {
        clientG = clg;
    }

    @Override
    public String addGuestRes(String name, String purpose, String date) {
        guestRes = new GuestRes(name, purpose, date);
        String guestNo = clientG.addGuestRes(guestRes).substring(32, 38);

        return guestNo;
    }

    @Override
    public ObservableList<GuestRes> allGuestReservations() {
        ObservableList listOfGuests = FXCollections.observableArrayList(clientG.getAllGuestReservation());
        return listOfGuests;
    }

    @Override
    public String cancelGuestReservation(String resNo) {
        return clientG.cancelGuestRes(resNo);
    }
}
