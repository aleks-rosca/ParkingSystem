package test;

import DB.Conn;
import DB.EmpDAO;
import DB.IEmpDAO;
import model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class EmpDAOTest {
    private IEmpDAO empDAO;
    private  Employee emp;
    private Conn conn;
    @BeforeEach
    public void setUp() throws ClassNotFoundException {
            empDAO = new EmpDAO();
       emp = new Employee("zsolt","E2289");

    }
    @AfterEach
    public void TearDown() throws SQLException {
       conn=  Conn.getInstance();
        String sql = "delete from  employee where empno='"+emp.getEmpNumber()+"';";
    conn.update(sql);
    }

    @org.junit.jupiter.api.Test
    void addEmployee() {

         String testInsert = empDAO.addEmployee(emp);

         assertSame("Employee added",testInsert);

         //testing that we get an error if we try to insert the same employee twice

        String testDuplicate = empDAO.addEmployee(emp);

        assertSame("Duplicate key",testDuplicate);




    }

    @Test
    void checkEmployeeByEmpNumber() {
        empDAO.addEmployee(emp);
        String empNo = emp.getEmpNumber();
        Boolean check = empDAO.checkEmployeeByEmpNumber(empNo);

        assertEquals(true,check);
    }
}