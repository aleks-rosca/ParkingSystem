package test;

import DB.*;
import model.Employee;
import model.EmployeeRes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmpCheckDAOTest {
    private IEmpCheckDAO epark;
    private IEmpResDAO eres;
    private IEmpDAO empDAO;
    private Conn conn;
    private EmployeeRes empres;
   private LocalDate dt;
    private LocalDate tomorrow ;
    @BeforeEach
    void setUp() {

     dt =  LocalDate.now();
        tomorrow = dt.plusDays(1);
        conn = Conn.getInstance();
        eres = new EmpResDAO();
        epark = new EmpCheckDAO();
        empDAO = new EmpDAO();
        Employee emp = new Employee("testUser2", "E2222");
        empDAO.addEmployee(emp);
         empres = new EmployeeRes(tomorrow.toString(),emp.getEmpNumber());



    }

    @AfterEach
    void tearDown() {
        String sql = "delete from parkinglot where ID='E2222';";// will be exchanged with delete method later

        try {
            conn.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    /*We are testing the without reservation and double parking in one test because for double we need a exsisting checkin*/
    void empCheckInWithoutReservationAndDoubleReservation() {
        String testcheckinEmp = epark.empCheckIn("E2222");
        assertSame("checked in to parking lot", testcheckinEmp);
        // testing double checking
        String testcheckinEmp2 = epark.empCheckIn("E2222");
        assertSame("Already checked in", testcheckinEmp2);
    }
    @Test
            /* For testing checkin with reservation we are using a seperate sql statement which uses the date of the reservation
             , because of constraint on employee reservations that doesn't allow us to insert current date
             the statement is nearly identical to the method we want tested except for date  */

    void empcheckinWithRes(){// we are also testing that reservations are removed after checking in to the parking lot
        eres.addReservetion(empres);
        String sql = "INSERT INTO parkinglot VALUES('E2222','E','"+tomorrow+"');";
        String sqlres= "select * from empres where empno='E2222'AND date='"+tomorrow+"';";
        String sqlParking= "select * from parkinglot where ID='E2222'AND date= '"+tomorrow+"';";
        boolean existsBefore= false;
        boolean existsAfter = false;
        boolean parkingExists = false;
        try {

            ResultSet rsBefore =  conn.query(sqlres);
            while(rsBefore.next()){
                existsBefore= true;
            }
            conn.update(sql);

            ResultSet rsAfter =  conn.query(sqlres);
            while(rsAfter.next()){
                existsAfter= true;
            }
            ResultSet rsCheckin = conn.query(sqlParking);
            while(rsCheckin.next()){

                parkingExists = true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        assertTrue(existsBefore);
        assertFalse(existsAfter);
        assertTrue(parkingExists);
    }

    @Test
    void invalidEmployeeNumber() {
        String testcheckinEmp = epark.empCheckIn("E9999");
        assertEquals("No such employee number", testcheckinEmp);

    }
}