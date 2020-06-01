package Model;

import DB.GuestResDAO;
import DB.IGuestResDAO;
import model.GuestRes;

import java.util.List;
import java.util.Random;

public class SModelU implements ISModelU {
    private final Random random;
    private final IGuestResDAO guestResDAO;

    public SModelU() {
        guestResDAO = new GuestResDAO();
        random = new Random();
    }

    @Override
    public String addGuestRes(GuestRes guestRes) {
        guestRes.setResNo("G" + (random.nextInt(9000) + 1000));
        return guestResDAO.addGuestRes(guestRes) + " " + guestRes.getResNo();
    }

    @Override
    public String cancelGuestRes(String resNo) {
        return guestResDAO.cancelGuestRes(resNo);
    }

    @Override
    public List<GuestRes> getAllGuestReserevation() {
        return guestResDAO.getAllGuestReserevation();
    }

}
