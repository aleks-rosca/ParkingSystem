package Model;

import model.Status;

import java.util.List;

public interface ISModelS {
    int getParkingStatus();

    List<Status> getAllStatuses();

    int getNumberOfGuestsInParkingLot();

    int getNumberOfEmployeesInParkingLot();

    int getNumberOfPublicUsersInParkingLot();
}
