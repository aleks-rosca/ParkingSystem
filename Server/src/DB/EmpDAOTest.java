package DB;

import model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class EmpDAOTest {
    private EmpDAO empDAO;
    private Conn db;
    @BeforeEach
    public void setUp() throws ClassNotFoundException {


          Conn db = new Conn();
            empDAO = new EmpDAO();

    }

    @org.junit.jupiter.api.Test
    void addEmployee() {
        Employee emp = new Employee("zsolt","E1234");
         String test = empDAO.addEmployee(emp);

         assertSame("Employee added",test);


    }


}