package Controller;

import Model.IMCGModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.GuestRes;

import java.rmi.RemoteException;

public class GuestReservationController {
    public TextField guestReservNameTf;
    public TextArea guestReservPurposeTf;
    public DatePicker guestReservDateDp;
    public IMCGModel gModel;

    @FXML
    TableView<GuestRes> guestReservTableTv;
    @FXML
    TableColumn<GuestRes, String> guestName;
    @FXML
    TableColumn<GuestRes, String> guestResNo;
    @FXML
    TableColumn<GuestRes, String> guestDate;
    @FXML
    TableColumn<GuestRes, String> guestPurpose;

    public void init(IMCGModel gModel) {
        this.gModel = gModel;
    }

    public void reservGuestBtn() {

        if (guestReservNameTf.getText().isEmpty()) {
            // create a alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Guest Name");
            alert.setHeaderText("Guest Name not added");
            alert.setContentText("Please add guest name");
            alert.getButtonTypes();
            alert.show();
        }
        if (guestReservDateDp.getValue() == null) {
            // create a alert
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Date");
            alert1.setHeaderText("Date not chosen");
            alert1.setContentText("Please chose a date");
            alert1.getButtonTypes();
            alert1.show();
        }

        else{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reservation");
            alert.setHeaderText("Reservation done");
            try {
                alert.setContentText("Guest reservation number is: " + gModel.addGuestRes(guestReservNameTf.getText(), guestReservPurposeTf.getText(), guestReservDateDp.getValue().toString()));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            alert.getButtonTypes();
            alert.show();
            guestReservNameTf.clear();
            guestReservPurposeTf.clear();
        }
        getAllGuestReservations();



    }

    public void deleteGuestReservation() {
        String resNo = guestReservTableTv.getSelectionModel().getSelectedItem().getResNo();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Delete " + guestReservTableTv.getSelectionModel().getSelectedItem().getName() + " ?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            gModel.cancelGuestReservation(resNo);
            guestReservTableTv.getItems().removeAll(guestReservTableTv.getSelectionModel().getSelectedItem());
        }

    }

    public void getAllGuestReservations() {
        guestName.setCellValueFactory(new PropertyValueFactory<>("name"));
        guestDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        guestResNo.setCellValueFactory(new PropertyValueFactory<>("resNo"));
        guestPurpose.setCellValueFactory(new PropertyValueFactory<>("purpose"));
        guestReservTableTv.setItems(gModel.allGuestReservations());

    }
}
