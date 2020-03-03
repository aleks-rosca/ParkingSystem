package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.EmployeeRes;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class EController implements IEController, Initializable {


    public TextField empNo;
    public DatePicker datePicker;
    public Button reserveButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    public void ECAction(ActionEvent actionEvent) {

    }

    public void reserveEmp(ActionEvent actionEvent) {
    EmployeeRes reservation = new EmployeeRes(datePicker.getValue().toString(),Integer.parseInt(empNo.getText()));
        System.out.println(reservation.getDate()+"\n"+reservation.getEmpNo());

     }
    }
}
