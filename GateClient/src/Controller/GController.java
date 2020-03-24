package Controller;

import Model.IGCModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.Timer;
import java.util.TimerTask;


public class GController {
    public Button checkinBtn;
    public TextField checkInTf;
    public IGCModel model;
    public Circle circle;
    public Circle gateStatus;
    public TextFlow warningField = new TextFlow();
    public Label spotsLeft;
    Text t1 = new Text("Welcome");
    Text t2 = new Text("Already Checked In!");
    Text t3 = new Text("Please Fill in All the fields!");
    Text t4 = new Text("Wrong Employee Number!");
    Text t5 = new Text("Wrong Reservation Number!");

    public void init(IGCModel model) {
        this.model = model;
        recheck();

    }

    private void reactToChange() {
        Platform.runLater(() -> spotsLeft.setText(String.valueOf(40 - model.getParkingStatus())));
    }


    public void checkIn(ActionEvent actionEvent) {
        t1.setFill(Color.GREEN);
        t1.setFont(Font.font("Verdana", 16));
        t2.setFill(Color.RED);
        t2.setFont(Font.font("Verdana", 16));
        t3.setFill(Color.RED);
        t3.setFont(Font.font("Verdana", 16));
        t4.setFill(Color.RED);
        t4.setFont(Font.font("Verdana", 16));
        t5.setFill(Color.RED);
        t5.setFont(Font.font("Verdana", 16));
        String check = model.checkClient(checkInTf.getText());


        if (check.equals("employee")) {
            String temp = model.empCheckIn(checkInTf.getText().trim());
            if (temp.equals("checked in to parking lot")) {
                warningField.getChildren().clear();
                gateStatus.setFill(Color.GREEN);

                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                gateStatus.setFill(Color.RED);
                            }
                        },
                        5000);

            } else if (temp.equals("No such employee number")) {
                warningField.getChildren().clear();
                warningField.getChildren().add(t4);


            } else if (temp.equals("Already checked in")) {
                warningField.getChildren().clear();
                warningField.getChildren().add(t2);
            }

        } else if (check.equals("guest")) {
            String temp = model.guestCheckIn(checkInTf.getText().trim());

            if (temp.equals("checked in to parking lot")) {
                gateStatus.setFill(Color.GREEN);
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                Platform.runLater(() -> gateStatus.setFill(Color.RED));
                            }
                        },
                        5000);
                warningField.getChildren().clear();
                warningField.getChildren().add(t1);

            } else if (temp.equals("No such reservation number")) {
                warningField.getChildren().clear();
                warningField.getChildren().add(t5);

            } else if (temp.equals("Already checked in")) {
                warningField.getChildren().clear();
                warningField.getChildren().add(t2);

            }


        } else if (check.equals("public")) {
            String temp = model.publicUserIn(checkInTf.getText().trim());
            if (temp.equals("checked in to parking lot")) {
                gateStatus.setFill(Color.GREEN);
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                Platform.runLater(() -> gateStatus.setFill(Color.RED));
                            }
                        },
                        5000);

                warningField.getChildren().clear();
            } else {
                warningField.getChildren().clear();
                warningField.getChildren().add(t3);

            }
            checkInTf.clear();
            reactToChange();


        }
    }

    public void recheck() {
        int MINUTES = 1;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                reactToChange();
            }
        }, 0, 1000 * 6 * MINUTES);
    }


}