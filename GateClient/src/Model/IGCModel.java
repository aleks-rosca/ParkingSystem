package Model;

public interface IGCModel {
    String empCheckIn(String empNo);
    String guestCheckIn(String resNo);
    String checkClient(String res);
    int getParkingStatus();
}
