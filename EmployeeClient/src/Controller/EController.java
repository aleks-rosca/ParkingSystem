package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.EmployeeRes;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class EController implements IEController, Initializable {


    public TextField empNo;
    public DatePicker datePicker;
    public Button reserveButton;
    private Component frame;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void ECAction(ActionEvent actionEvent) {

    }

    public void reserveEmp(ActionEvent actionEvent) {
        //create new reservation after button click
        EmployeeRes reservation = new EmployeeRes(datePicker.getValue().toString(), Integer.parseInt(empNo.getText()));
        //Line for JUnit test
        //System.out.println(reservation.getDate() + "\n" + reservation.getEmpNo());

        //check if employee number has exactly 8 digits
        int length = (int) (Math.log10(reservation.getEmpNo()) + 1);
        if (length != 8) {
            //if it's more or less than 8 displays warning message
            JOptionPane.showMessageDialog(frame,
                    "Entered employee number is too short",
                    "Inane warning",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            //if it's correct displays information and shows date + reservation number
            JOptionPane.showMessageDialog(frame,
                    "You successfully reserved spot for " + reservation.getDate() + "\n Your reservation number is: " + reservation.getReservationNo());
        }
    }
}
