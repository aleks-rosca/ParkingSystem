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

import java.util.Timer;
import java.util.TimerTask;


public class GController {
    public Button checkinBtn;
    public TextField checkInTf;
    public IGCModel model;
    public Circle gateStatus;
    public Label warningField;
    public Label spotsLeft;

    public void init(IGCModel model) {
        this.model = model;
        recheck();
    }


    public void openGate() {
        gateStatus.setFill(Color.GREEN);
        warningField.setText("Welcome!");
        warningField.setTextFill(Color.GREEN);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        gateStatus.setFill(Color.RED);
                    }
                },
                5000);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(() -> warningField.setText(""));
                    }
                },
                5000);
    }

    public void alreadyCheckedIn() {
        warningField.setText("Already Checked In!");
        warningField.setTextFill(Color.RED);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(() -> warningField.setText(""));
                    }
                },
                5000);
    }

    public void wrongEmployeeNo() {
        warningField.setText("Wrong Employee Number!");
        warningField.setTextFill(Color.RED);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(() -> warningField.setText(""));
                    }
                },
                5000);
    }

    public void wrongResNo() {
        warningField.setText("Wrong Reservation Number!");
        warningField.setTextFill(Color.RED);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(() -> warningField.setText(""));
                    }
                },
                5000);
    }

    public void checkIn(ActionEvent actionEvent) {
        warningField.setFont(Font.font("Verdana", 16));
        String check = model.checkClient(checkInTf.getText());

        if (check.equals("employee")) {
            String temp = model.empCheckIn(checkInTf.getText().trim());
            if (temp.equals("checked in to parking lot")) {
                openGate();

            } else if (temp.equals("No such employee number")) {
                wrongEmployeeNo();

            } else if (temp.equals("Already checked in")) {
                alreadyCheckedIn();
            }

        } else if (check.equals("guest")) {
            String temp = model.guestCheckIn(checkInTf.getText().trim());
            if (temp.equals("checked in to parking lot")) {
                openGate();

            } else if (temp.equals("No such reservation number")) {
                wrongResNo();

            } else if (temp.equals("Already checked in")) {
                alreadyCheckedIn();
            }

        } else if (check.equals("public")) {
            String temp = model.publicUserIn(checkInTf.getText().trim());
            if (temp.equals("checked in to parking lot")) {
                openGate();

            } else if (temp.equals("Already checked in")) {
                alreadyCheckedIn();
            }

        } else if (check.equals("empty")) {
            warningField.setText("Please enter your Credentials");
            warningField.setTextFill(Color.RED);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            Platform.runLater(() -> warningField.setText(""));
                        }
                    },
                    5000);
        } else if (check.equals("error")) {
            warningField.setText("Invalid input");
            warningField.setTextFill(Color.RED);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            Platform.runLater(() -> warningField.setText(""));
                        }
                    },
                    5000);
        }
        checkInTf.clear();
        reactToChange();
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

    public void reactToChange() {
        Platform.runLater(() -> spotsLeft.setText(String.valueOf(model.getParkingStatus())));
    }


}