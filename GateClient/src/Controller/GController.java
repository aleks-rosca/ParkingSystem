package Controller;

import Model.IGCModel;
import Observer.PropertyChangeSubject;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class GController implements PropertyChangeSubject {
    public Button checkinBtn;
    public TextField checkInTf;
    public IGCModel model;
    public Circle circle;
    public Circle gateStatus;
    public TextFlow warningField = new TextFlow();
    public Label spotsLeft;
    private int spotsDB;
    private PropertyChangeSupport support;

    Text t1 = new Text("Welcome");
    Text t2 = new Text("Already Checked In!");
    Text t3 = new Text("Please Fill in All the fields!");
    Text t4 = new Text("Wrong Employee Number!");
    Text t5 = new Text("Wrong Reservation Number!");

    public void employeeBtn(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Employee Gate View");
        dialog.setHeaderText("Enter Employee Number to proceed");
        dialog.setContentText("Employee Number:");

    }

    public void init(IGCModel model) {
        this.model = model;
        support = new PropertyChangeSupport(this);
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

                support.firePropertyChange("CheckIn",spotsLeft.getText(),spotsDB-1);

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
                warningField.getChildren().clear();
                warningField.getChildren().add(t1);

            } else if (temp.equals("No such reservation number")) {
                warningField.getChildren().clear();
                warningField.getChildren().add(t5);

            } else if (temp.equals("Already checked in")) {
                warningField.getChildren().clear();
                warningField.getChildren().add(t2);

            }

        } else {
            warningField.getChildren().clear();
            warningField.getChildren().add(t3);

        }
        checkInTf.clear();


    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)){
            addPropertyChangeListener(listener);
        }else {
            support.addPropertyChangeListener(eventName,listener);
        }
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)){
            removePropertyChangeListener(listener);
        }else {
            support.removePropertyChangeListener(eventName,listener);
        }
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}