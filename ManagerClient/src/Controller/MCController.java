package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.ResourceBundle;


public class MCController implements Initializable
{
    @FXML
    private CEmployeeReservation cEmployeeReservation;
    @FXML
    private CGuestReservation cGuestReservation;
    @FXML
    private CManageEmployee cManageEmployee;
    @FXML
    private CParkingStatus cParkingStatus;

    @FXML
    private TabPane parkingTabPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
