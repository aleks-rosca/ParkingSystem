package GateClientOUT;

public interface IGClient {
    String empCheckOut(String empNo);
    String guestCheckOut(String resNo);
    String publicCheckOut(String plate);
}
