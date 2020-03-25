package DB;

import model.Status;

import java.util.List;

public interface IStatusDAO {

    int getCurrentStatus();
    List<Status> getAllStatuses();
    int getNumberOfGuestsInParkingLot();
    int getNumberOfEmployeesInParkingLot();
    int getNumberOfPublicUsersInParkingLot();


}
