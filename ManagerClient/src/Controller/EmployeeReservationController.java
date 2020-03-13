package Controller;

import Model.IMCEModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;

public class EmployeeReservationController {
    public TextField empReservNumTf;
    public DatePicker empReservDateDp;
    public IMCEModel mceModel;

    public void init(IMCEModel mceModel) {
        this.mceModel = mceModel;
    }


    public void reservBtnClick(ActionEvent actionEvent) {
        try {
            mceModel.addEmpRes(empReservDateDp.getValue().toString(), empReservNumTf.getText());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

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