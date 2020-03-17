package Controller;

import Model.IGCModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.shape.Circle;


public class GController {
    public Button checkinBtn;
    public TextField checkInTf;
    public IGCModel model;
    public Circle circle;

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

        if (checkInTf.getText().trim().isEmpty()) {
            // create a alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill in the fields");
            alert.show();
        }
        //model.empCheckIn(checkInTf.getText());
        else if(model.empCheckIn(checkInTf.getText()).equals("checked in to parking lot")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Checked In");
            alert.show();

        }
        else if(model.empCheckIn(checkInTf.getText()).equals("No such employee number")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("No such Employee");
            alert.show();

        }
        else if(model.empCheckIn(checkInTf.getText()).equals("Already checked in")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Already Checked In");
            alert.show();

        }

    }
}