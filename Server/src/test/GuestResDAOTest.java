package test;

import DB.GuestResDAO;
import DB.IGuestResDAO;
import model.GuestRes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestResDAOTest {
    IGuestResDAO guestResDAO;
    GuestRes newGuest;
    @BeforeEach
    void setUp() {
        guestResDAO = new GuestResDAO();
        newGuest = new GuestRes("testGuest","testing","2020-03-14");
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
}