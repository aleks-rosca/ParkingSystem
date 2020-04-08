package Model;

import model.GuestRes;

import java.util.List;

public interface ISModelU {
    String addGuestRes(GuestRes guestRes);
    String cancelGuestRes(String resNo);

    List<GuestRes> getAllGuestReserevation();
}
