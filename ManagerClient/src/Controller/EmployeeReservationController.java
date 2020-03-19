package Controller;

import Model.IMCEModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.rmi.RemoteException;
import java.time.LocalDate;

public class EmployeeReservationController {
    public TextField empReservNumTf;
    public DatePicker empReservDateDp;
    public IMCEModel mceModel;

    public void init(IMCEModel mceModel) {
        this.mceModel = mceModel;
    }


    public void reservBtnClick(ActionEvent actionEvent) throws IOException {


        if (!(empReservNumTf.getText().isEmpty()) & !(String.valueOf(empReservDateDp.getValue()).equals("null"))) {
               String temp = mceModel.addEmpRes(empReservDateDp.getValue().toString(), empReservNumTf.getText());
               if(temp.equals("Reservation is not created")){
                   Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Reservation is not created", ButtonType.OK);
                   a1.show();
               }else if(temp.equals("You can not create reservation for same day or more than 7 days ahead")){
                   Alert a1 = new Alert(Alert.AlertType.INFORMATION, "You can not create reservation for same day or more than 7 days ahead", ButtonType.OK);
                   a1.show();
               }else if(temp.equals("Reservation is created")){
                   Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Reservation is created", ButtonType.OK);
                   a1.show();
               }else {
                   Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Check your connection and try again", ButtonType.OK);
                   a1.show();
               }



        } else {
            // create a alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fields are empty");
            alert.setContentText("All of the fields must be filled");
            alert.getButtonTypes();
            alert.show();
        }

    }
}