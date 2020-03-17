package test;


import DB.*;
import model.GuestRes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GuestCheckDAOTest {
    private IGuestCheckDAO gpark;
    private IGuestResDAO gres;
    private Conn conn;
    private GuestRes guestres;
    private LocalDate dt;
    private LocalDate tomorrow ;
    @BeforeEach
    void setUp() {
        dt =  LocalDate.now();
        tomorrow = dt.plusDays(1);
        conn = Conn.getInstance();
        gres = new GuestResDAO();
        gpark = new GuestCheckDAO();
        guestres = new GuestRes("testGuest","testCompany",tomorrow.toString());
        guestres.setResNo("G0001");
        gres.addGuestRes(guestres);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void guestCheckIn() {/* only difference between this sql statement and the method in the DAO is that in DAO the date is set to current date and constraints restricts us from
     creating a reservation for the current day*/
        String sqlParking= "INSERT INTO parkinglot values('"+guestres.getResNo()+"','G','"+tomorrow+"');";
        boolean parkingExists = false;
        try {
            conn.update(sqlParking);
            parkingExists = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(parkingExists);

    }

    @Test
    void guestCheckOut() {
        guestCheckIn();
        String testCheckOut = gpark.guestCheckOut(guestres.getResNo());

        assertEquals("checked out",testCheckOut);

    }
}