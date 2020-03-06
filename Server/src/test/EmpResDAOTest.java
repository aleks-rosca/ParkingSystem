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
      conn=   Conn.getInstance(); // used for deleting reservation after they have been tested
        test = new EmpResDAO();
        testReservation = new EmployeeRes("2020/03/13","E1289");
    }

    @AfterEach
    void tearDown() throws SQLException {
        String sql = "delete from empres where empno='"+testReservation.getEmpNo()+"';";
        conn.update(sql);

    }

    @Test
    void addReservetion() {

        String  testResponse = test.addReservetion(testReservation);
        assertSame("Reservation is created",testResponse);
    }
}