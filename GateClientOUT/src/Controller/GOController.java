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

public class GOController {
    public TextField checkOutTf;
    public IGCModel model;
    public Button checkOutBtn;
    public Circle gateStatus;
    public Label warningField;

    public void init(IGCModel model) {
        this.model = model;
    }

    public void checkOut(ActionEvent actionEvent) {
        warningField.setFont(Font.font("Verdana", 16));
        String check = model.checkClient(checkOutTf.getText());

        if (check.equals("employee")) {
            String temp = model.empCheckOut(checkOutTf.getText());
            if (temp.equals("checked out")) {
                gateStatus.setFill(Color.GREEN);
                warningField.setText("Have a nice day!");
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

            } else if (temp.equals("something went wrong with check out")) {
                warningField.setText("Something went wrong");
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
        } else if (check.equals("guest")) {
            String temp = model.guestCheckOut(checkOutTf.getText());
            if (temp.equals("checked out")) {
                gateStatus.setFill(Color.GREEN);
                warningField.setText("Have a nice day!");
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
            } else if (temp.equals("something went wrong with check out")) {
                warningField.setText("Something went wrong");
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

        } else if (check.equals("public")) {
            String temp = model.publicCheckOut(checkOutTf.getText());
            if (temp.equals("checked out")) {
                gateStatus.setFill(Color.GREEN);
                warningField.setText("Have a nice day!");
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

            } else if (temp.equals("something went wrong with check out")) {
                warningField.setText("Something went wrong");
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

        } else if (check.equals("empty")) {
            warningField.setText("Please Fill in All the fields!");
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
        checkOutTf.clear();

    }

}
