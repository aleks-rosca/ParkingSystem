package Controller;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CEmployeeReservation {
    public TextField empReservNumTf;
    public DatePicker empReservDateDp;
    private Model model;

    public CEmployeeReservation() throws RemoteException, NotBoundException, MalformedURLException {
        model = new Model();
    }


    public void reservBtnClick(ActionEvent actionEvent) throws IOException {
        model.addEmpRes(empReservDateDp.getValue().toString(), empReservNumTf.getText());

        if (empReservNumTf.getText().trim().isEmpty()) {
            // create a alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Employee Number");
            alert.setHeaderText("Employee number not added");
            alert.setContentText("Please add employee number to reserve a spot for given date");
            alert.getButtonTypes();

            alert.show();
        }
        if (empReservDateDp.getValue() == null) {
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