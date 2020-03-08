package test;

import DB.Conn;
import DB.EmpResDAO;
import DB.IEmpResDAO;
import model.EmployeeRes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertSame;

class EmpResDAOTest {
    IEmpResDAO test;
    private Conn conn;
    private EmployeeRes testReservation;

    @BeforeEach
    void setUp() {
        conn = Conn.getInstance(); // used for deleting reservation after they have been tested
        test = new EmpResDAO();
        testReservation = new EmployeeRes("2020/03/13", "E1289");
    }

    @AfterEach
    void tearDown() throws SQLException {
          String sql = "delete from empres where empno='"+testReservation.getEmpNo()+"';";
        conn.update(sql);

    }

    @Test
    void addReservetion() {

        String testInsert = test.addReservetion(testReservation);
        assertSame("Reservation is created", testInsert);
    //testing response on dublicate reservation ( same employee on same day)

        String testDublicate = test.addReservetion(testReservation);
        assertSame("Reservation is not created", testDublicate);
        //testing that employee can make multiple for more days
        EmployeeRes testReservation2 = new EmployeeRes("CURRENT_DATE+1", "E1289");
        String testInsert2 = test.addReservetion(testReservation);
        assertSame("Reservation is created", testInsert);
        // testing that employee can't book for current date or 7+ days ahead
        //EmployeeRes testReservation3 = new EmployeeRes("CURRENT_DATE", "E1289");
        String testSameDay = test.addReservetion(testReservation);
        assertSame("Reservation is not created", testSameDay);
        //EmployeeRes testReservation4 = new EmployeeRes("CURRENT_DATE+8", "E1289");
        String testMoreThanSeven = test.addReservetion(testReservation);
        assertSame("Reservation is not created", testMoreThanSeven);


    }
}