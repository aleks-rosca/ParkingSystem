package ManagerClient;

import model.GuestRes;

import java.util.List;

public interface IManagerClientG {
    String addGuestRes(GuestRes guestRes);

    String cancelGuestRes(String resNo);

    List<GuestRes> getAllGuestReservation();


}
