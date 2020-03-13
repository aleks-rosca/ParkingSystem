package Controller;

import Model.IGCModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class GOController {
    public TextField checkInTf;
    public IGCModel model;
    public Button checkOutBtn;

    public void employeeBtn(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Employee Gate View");
        dialog.setHeaderText("Enter Employee Number to proceed");
        dialog.setContentText("Employee Number:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("Employee Number: " + result.get());
        }

        result.ifPresent(name -> System.out.println("Your name: " + name));
    }

    public void init(IGCModel model) {
        this.model = model;
    }

    public void checkOut(ActionEvent actionEvent) {
        model.empCheckOut(checkInTf.getText());

    }
}
