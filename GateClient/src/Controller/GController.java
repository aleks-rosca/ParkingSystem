package Controller;

import Model.IGCEmodel;
import javafx.event.ActionEvent;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class GController {
    public void employeeBtn(ActionEvent actionEvent)
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Employee Gate Voew");
        dialog.setHeaderText("Enter Employee Number to proceed");
        dialog.setContentText("Employee Number:");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            System.out.println("Employee Number: " + result.get());
        }

// The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> System.out.println("Your name: " + name));
    }

    public void init(IGCEmodel model)
    {
    }
}
