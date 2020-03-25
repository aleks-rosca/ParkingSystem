package Controller;

import Model.IMCEModel;
import Model.IMCGModel;
import Model.IMCPModel;
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


    public void init(IMCEModel model, IMCGModel gModel, IMCPModel pModel) {
        manageEmployeeController.init(model);
        employeeReservationController.init(model);
        guestReservationController.init(gModel);
        parkingStatusController.init(pModel);
    }


    public void updateGr() {
        guestReservationController.getAllGuestReservations();

    }

    public void updateEr() {
        employeeReservationController.showAllEmployeeReservations();
    }

    public void updateEm() {
        manageEmployeeController.showAllEmployee();
    }


}
