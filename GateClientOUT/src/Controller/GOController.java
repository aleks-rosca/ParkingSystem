package Controller;

import Model.IGCModel;
import Observer.PropertyChangeSubject;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GOController implements PropertyChangeSubject {
    public TextField checkOutTf;
    public IGCModel model;
    public Button checkOutBtn;
    public Circle gateStatus;

    private PropertyChangeSupport support;

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

    public void checkOut(ActionEvent actionEvent) {

        String temp = model.empCheckOut(checkOutTf.getText());
        if (checkOutTf.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill in the fields");
            alert.show();
        } else if (temp.equals("checked out")) {
            gateStatus.setFill(Color.GREEN);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            gateStatus.setFill(Color.RED);
                        }
                    },
                    5000);
            support.firePropertyChange("CheckIn",null,-1);

        } else if (temp.equals("something went wront with check out")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Something went wrong, try again");
            alert.show();

        }
        checkOutTf.clear();
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
