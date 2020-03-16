package DB;

public interface IGuestCheckDAO {
    String guestCheckIn(String reservationNo);
    String guestCheckOut(String reservationNo);

}
