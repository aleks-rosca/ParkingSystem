package Controller;

import Model.IMCGModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;

public class GuestReservationController {
    public TextField guestReservNameTf;
    public TextArea guestReservPurposeTf;
    public DatePicker guestReservDateDp;
    public IMCGModel gModel;

    public void init(IMCGModel gModel) {
        this.gModel = gModel;
    }

    public void reservGuestBtn(ActionEvent actionEvent) {
        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reservation");
            alert.setHeaderText("Reservation done");
            alert.setContentText("Reservation added. Guest reservation number is: " + gModel.addGuestRes(guestReservNameTf.getText(), guestReservPurposeTf.getText(), guestReservDateDp.getValue().toString()));
            alert.getButtonTypes();
            alert.show();

        } catch (RemoteException e) {
            e.printStackTrace();
        }

        if (guestReservNameTf.getText().trim().isEmpty()) {
            // create a alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Guest Name");
            alert.setHeaderText("Guest Name not added");
            alert.setContentText("Please add guest name to reserve a spot for given date");
            alert.getButtonTypes();
            alert.show();
        }
        if (guestReservDateDp.getValue() == null) {
            // create a alert
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Date");
            alert1.setHeaderText("Date not chosen");
            alert1.setContentText("Chose a date to reserve a parking on the given date");
            alert1.getButtonTypes();
            alert1.show();
        }
        if (guestReservPurposeTf.getText().trim().isEmpty()) {
            // create a alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Purpose");
            alert.setHeaderText("Purpose not added");
            alert.setContentText("Please add the purpose on the guest visit");
            alert.getButtonTypes();
            alert.show();
        }
        guestReservNameTf.clear();
        guestReservPurposeTf.clear();
    }
}
