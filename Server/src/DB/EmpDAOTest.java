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
    public void setUp() {


        try {
            Conn db = new Conn();
            empDAO = new EmpDAO(db);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @org.junit.jupiter.api.Test
    void addEmployee() {
        Employee emp = new Employee("aleks","ar987");
        empDAO.addEmployee(emp);


    }


}