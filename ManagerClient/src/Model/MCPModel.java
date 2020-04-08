package Model;

import ManagerClient.IManagerClient;
import ManagerClient.IManagerClientS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Status;

public class MCPModel implements IMCPModel {
    private IManagerClientS managerClientS;

    public MCPModel(IManagerClientS cls){

        managerClientS = cls;


    }
    public MCPModel(){}

    @Override
    public ObservableList<Status> getAllStatues() {
        ObservableList<Status> statuses = FXCollections.observableArrayList(managerClientS.getAllStatues());

        return statuses;
    }

    @Override
    public int getOccupiedSpots() {
        return (40 - managerClientS.getCurrentStatus());
    }

    @Override
    public int getNumberOfGuestsInParkingLot() {
        return managerClientS.getNumberOfGuestsInParkingLot();
    }

    @Override
    public int getNumberOfEmployeesInParkingLot() {
        return managerClientS.getNumberOfEmployeesInParkingLot();
    }

    @Override
    public int getNumberOfPublicUsersInParkingLot() {
        return managerClientS.getNumberOfPublicUsersInParkingLot();
    }
}
