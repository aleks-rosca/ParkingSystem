package DB;

import model.GuestRes;

import java.util.List;

public interface IGuestResDAO {

    String addGuestRes(GuestRes guestRes);
    String cancelGuestRes(String resNo);
    List<GuestRes> getAllGuestReserevation();
}
