package Controller;

import Model.IGCModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class GOController {
    public TextField checkOutTf;
    public IGCModel model;
    public Button checkOutBtn;

    public void employeeBtn(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Employee Gate View");
        dialog.setHeaderText("Enter Employee Number to proceed");
        dialog.setContentText("Employee Number:");

    }

    public void init(IGCModel model) {
        this.model = model;
    }

    public void checkOut(ActionEvent actionEvent) {

        String temp = model.empCheckOut(checkOutTf.getText());
        if (checkOutTf.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill in the fields");
            alert.show();
        } else if (temp.equals("checked out")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Checked Out");
            alert.show();

        } else if (temp.equals("something went wront with check out")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Something went wrong, try again");
            alert.show();

        }
        checkOutTf.clear();
    }
}
