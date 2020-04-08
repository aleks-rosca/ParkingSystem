package Model;

import ManagerClient.IManagerClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.GuestRes;

public class MCGModel implements IMCGModel{

    private IManagerClient client;
    private GuestRes guestRes;

    public MCGModel(IManagerClient cl){
        client = cl;
    }

    @Override
    public String addGuestRes(String name, String purpose, String date) {
        guestRes = new GuestRes(name, purpose, date);
        String guestNo = client.addGuestRes(guestRes).substring(32,38);

        return guestNo;
    }

    @Override
    public ObservableList<GuestRes> allGuestReservations() {
        ObservableList listOfGuests= FXCollections.observableArrayList(client.getAllGuestReservation());
        return listOfGuests ;
    }

    @Override
    public String cancelGuestReservation(String resNo) {
        return client.cancelGuestRes(resNo);
    }
}
