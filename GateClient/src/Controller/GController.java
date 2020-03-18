package Controller;

import Model.IGCModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.concurrent.TimeUnit;


public class GController {
    public Button checkinBtn;
    public TextField checkInTf;
    public IGCModel model;
    public Circle circle;
    public Circle gateStatus;

    public void employeeBtn(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Employee Gate View");
        dialog.setHeaderText("Enter Employee Number to proceed");
        dialog.setContentText("Employee Number:");

    }

    public void init(IGCModel model) {
        this.model = model;
    }

    public void checkIn(ActionEvent actionEvent) {
        String check = model.checkClient(checkInTf.getText());
        if (check.equals("employee")) {
            String temp = model.empCheckIn(checkInTf.getText().trim());
            gateStatus.setFill(Color.RED);

            if (temp.equals("checked in to parking lot")) {
                gateStatus.setFill(Color.GREEN);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Checked In");
                alert.show();

            } else if (temp.equals("No such employee number")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("No such Employee");
                alert.show();

            } else if (temp.equals("Already checked in")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Already Checked In");
                alert.show();

            }

        } else if (check.equals("guest")) {
            String temp = model.guestCheckIn(checkInTf.getText().trim());

            if (temp.equals("checked in to parking lot")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Checked In");
                alert.show();

            } else if (temp.equals("No such reservation number")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("No such reservation");
                alert.show();

            } else if (temp.equals("Already checked in")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Already Checked In");
                alert.show();

            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill in the fields with valid information");
            alert.show();
        }
        checkInTf.clear();


    }
}