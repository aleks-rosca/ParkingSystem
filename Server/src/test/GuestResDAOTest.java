package test;

import DB.GuestResDAO;
import DB.IGuestResDAO;
import model.GuestRes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GuestResDAOTest {
    IGuestResDAO guestResDAO;
    GuestRes newGuest;
    private LocalDate dt;
    private LocalDate tomorrow ;
    private ArrayList<GuestRes> testArray=new ArrayList<>();
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
        guestResDAO.cancelGuestRes(newGuest.getResNo());
         String test =guestResDAO.addGuestRes(newGuest);
        assertEquals("Reservation for guest is created",test);

        //to clear db


    }
    @Test
    void cancelGuestRes(){
       // System.out.println(guestResDAO.addGuestRes(newGuest));
        String test=guestResDAO.cancelGuestRes(newGuest.getResNo());
        assertEquals("cancellation succeeded",test);
    }
    @Test
    void getAllGuestReservations(){
        System.out.println(guestResDAO.addGuestRes(newGuest));
        testArray.add(newGuest);
        newGuest = new GuestRes("testGuest","testing",tomorrow.toString(),"G0001");
        System.out.println(guestResDAO.addGuestRes(newGuest));
        testArray.add(newGuest);
        newGuest = new GuestRes("testGuest","testing",tomorrow.toString(),"G0002");
        System.out.println(guestResDAO.addGuestRes(newGuest));
        testArray.add(newGuest);
            assertEquals(testArray.size(),guestResDAO.getAllGuestReserevation().size());
    }
}