package Controller;

import Model.IECModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.rmi.RemoteException;

public class EReservationController {

    public IECModel ecModel;
    public TextField empNoTF;
    public DatePicker choosedate;
    public TableView empTw;
    public TableColumn c1;
    public TableColumn c2;

    public void init(IECModel ecModel) {
        this.ecModel = ecModel;
    }

    public void reservate(ActionEvent actionEvent) throws IOException {
        ecModel.addEmpRes(choosedate.getValue().toString(),empNoTF.getText());
        if (empNoTF.getText().trim().isEmpty()) {
            // create a alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Employee Number");
            alert.setHeaderText("Employee number not added");
            alert.setContentText("Please add employee number to reserve a spot for given date");
            alert.getButtonTypes();

            alert.show();
        }
        if (choosedate.getValue() == null) {
            // create a alert
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Date");
            alert1.setHeaderText("Date not chosen");
            alert1.setContentText("Chose a date to reserve a parking on the given date");
            alert1.getButtonTypes();

            alert1.show();
        }



    }
}
