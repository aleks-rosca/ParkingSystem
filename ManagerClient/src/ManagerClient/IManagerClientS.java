package ManagerClient;

import model.Status;

import java.util.List;

public interface IManagerClientS {
    List<Status> getAllStatues();

    int getCurrentStatus();

    int getNumberOfGuestsInParkingLot();

    int getNumberOfEmployeesInParkingLot();

    int getNumberOfPublicUsersInParkingLot();
}
