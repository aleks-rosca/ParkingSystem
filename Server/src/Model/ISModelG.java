package Model;

import model.Status;

import java.util.List;

public interface ISModelG {
    String empCheckIn(String empNo);

    String empCheckOut(String empNo);

    String guestCheckIn(String resNo);

    String guestCheckOut(String resNo);

    String publicUserIn(String licencePlate);

    String publicUserOut(String licencePlate);

    int getParkingStatus();

    List<Status> getAllStatuses();

    int getNumberOfGuestsInParkingLot();

    int getNumberOfEmployeesInParkingLot();

    int getNumberOfPublicUsersInParkingLot();
}
