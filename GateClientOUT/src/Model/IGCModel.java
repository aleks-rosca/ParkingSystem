package Model;

public interface IGCModel {
    String empCheckOut(String empNo);
    String guestCheckOut(String resNo);
    String checkClient(String check);
    String publicCheckOut(String plate);
}
