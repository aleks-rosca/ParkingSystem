package GateClient;

public interface IGClient {
    String empCheckIn(String empNo);
    String guestCheckin(String resNo);
    int getParkingStatus();

}
