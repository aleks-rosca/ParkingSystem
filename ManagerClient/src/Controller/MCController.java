package Controller;

import Model.IMCEModel;
import Model.IMCGModel;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;


public class MCController {

    @FXML
    public EmployeeReservationController employeeReservationController;
    @FXML
    public GuestReservationController guestReservationController;
    @FXML
    public ManageEmployeeController manageEmployeeController;
    @FXML
    public ParkingStatusController parkingStatusController;
    @FXML
    private TabPane parkingTabPane;


    public void init(IMCEModel model, IMCGModel gModel) {
        manageEmployeeController.init(model);
        employeeReservationController.init(model);
        guestReservationController.init(gModel);
    }


}
