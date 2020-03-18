package test;

import DB.GuestResDAO;
import DB.IGuestResDAO;
import model.GuestRes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GuestResDAOTest {
    IGuestResDAO guestResDAO;
    GuestRes newGuest;
    private LocalDate dt;
    private LocalDate tomorrow ;
    @BeforeEach
    void setUp() {
        dt =  LocalDate.now();
        tomorrow = dt.plusDays(1);
        guestResDAO = new GuestResDAO();
        newGuest = new GuestRes("testGuest","testing",tomorrow.toString());
        newGuest.setResNo("G1234");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addGuestRes() {
         String test =guestResDAO.addGuestRes(newGuest);
        assertEquals("Reservation for guest is created",test);
    }
    @Test
    void cancelGuestRes(){
        System.out.println(guestResDAO.addGuestRes(newGuest));
        String test=guestResDAO.cancelGuestRes(newGuest.getResNo());
        assertEquals("cancellation succeeded",test);
    }
}