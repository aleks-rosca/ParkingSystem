package Model;

import ManagerClient.IManagerClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Status;

public class MCPModel implements IMCPModel {
    private IManagerClient managerClient;

    public MCPModel(IManagerClient cl){

        managerClient = cl;


    }
    public MCPModel(){}

    @Override
    public ObservableList<Status> getAllStatues() {
        ObservableList<Status> statuses = FXCollections.observableArrayList(managerClient.getAllStatues());

        return statuses;
    }

    @Override
    public int getOccupiedSpots() {
        return managerClient.getCurrentStatus();
    }

    @Override
    public int getNumberOfGuestsInParkingLot() {
        return managerClient.getNumberOfGuestsInParkingLot();
    }

    @Override
    public int getNumberOfEmployeesInParkingLot() {
        return managerClient.getNumberOfEmployeesInParkingLot();
    }

    @Override
    public int getNumberOfPublicUsersInParkingLot() {
        return managerClient.getNumberOfPublicUsersInParkingLot();
    }
}
