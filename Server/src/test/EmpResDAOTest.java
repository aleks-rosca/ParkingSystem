package test;

import DB.*;
import model.Employee;
import model.EmployeeRes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmpResDAOTest {
    IEmpResDAO test;
    private Conn conn;
    private EmployeeRes testReservation;
    private IEmpDAO empdao; // used to create a test Employee
    private LocalDate dt;
    private LocalDate tomorrow ;
    private Employee testEmployee;
    @BeforeEach
    void setUp() {
        conn = Conn.getInstance(); // used for deleting reservation after they have been tested
        test = new EmpResDAO();
        empdao = new EmpDAO();
        dt =  LocalDate.now();
        tomorrow = dt.plusDays(1);
       testEmployee = new Employee("Test","Employee","E1289");
        empdao.addEmployee(testEmployee);

        testReservation = new EmployeeRes(tomorrow.toString(), "E1289");
    }

    @AfterEach
    void tearDown() throws SQLException {
          empdao.deleteEmployee(testEmployee);

    }

    @Test
    void addReservetion() {

        String testInsert = test.addReservetion(testReservation);
       assertSame("Reservation is created", testInsert);
    //testing response on dublicate reservation ( same employee on same day)

        String testDublicate = test.addReservetion(testReservation);
        assertSame("Reservation is not created", testDublicate);
        //testing that employee can make multiple for more days
        EmployeeRes testReservation2 = new EmployeeRes(dt.plusDays(3).toString(), "E1289");
        String testInsert2 = test.addReservetion(testReservation2);
        assertSame("Reservation is created", testInsert);
//        // testing that employee can't book for current date
        EmployeeRes testReservation3 = new EmployeeRes(dt.toString(), "E1289");
        String testSameDay = test.addReservetion(testReservation3);
        assertSame("You can not create reservation for same day or more than 7 days ahead", testSameDay);
      //7+ days
        EmployeeRes testReservation4 = new EmployeeRes(dt.plusDays(8).toString(), "E1289");
        String testMoreThanSeven = test.addReservetion(testReservation4);
        assertSame("You can not create reservation for same day or more than 7 days ahead", testMoreThanSeven);


    }
    @Test
    void cancelRervation(){
        test.addReservetion(testReservation);
        String str= test.cancelReservation(testReservation);

        assertSame("cancellation succeeded",str);

    }

    @Test
    void listOfReservationByEmpNo(){
        assertTrue(test.reservationsByEmpNo("E1289").isEmpty());
        test.addReservetion(testReservation);
        ArrayList<EmployeeRes>testList= new ArrayList<>();
        testList.add(testReservation);
        int size=  testList.size();
        int size2= test.reservationsByEmpNo("E1289").size();
        assertEquals(size,size2);


    }
    @Test
    void allEmployeeReservations(){

    }



}
