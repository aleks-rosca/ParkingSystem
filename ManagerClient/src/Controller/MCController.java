package Controller;

import Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;

import javafx.scene.control.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;


public class MCController implements Initializable
{
    private Model model;

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


    public MCController() throws RemoteException, NotBoundException, MalformedURLException
    {
        model = new Model();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
