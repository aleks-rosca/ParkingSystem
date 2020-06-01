package Model;

import DB.IStatusDAO;
import DB.StatusDAO;
import model.Status;

import java.util.List;

public class SModelS implements ISModelS {
    private final IStatusDAO statusDAO;

    public SModelS(){
        statusDAO = new StatusDAO();
    }

    @Override
    public int getParkingStatus() {
        return statusDAO.getCurrentStatus();
    }

    @Override
    public List<Status> getAllStatuses() {
        return statusDAO.getAllStatuses();
    }

    @Override
    public int getNumberOfGuestsInParkingLot() {
        return statusDAO.getNumberOfGuestsInParkingLot();
    }

    @Override
    public int getNumberOfEmployeesInParkingLot() {
        return statusDAO.getNumberOfEmployeesInParkingLot();
    }

    @Override
    public int getNumberOfPublicUsersInParkingLot() {
        return statusDAO.getNumberOfPublicUsersInParkingLot();
    }
}
