package DB;

import model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class EmpDAOTest {
    private EmpDAO empDAO;
    @BeforeEach
    public void setUp() throws ClassNotFoundException {


            empDAO = new EmpDAO();

    }

    @org.junit.jupiter.api.Test
    void addEmployee() {
        Employee emp = new Employee("zsolt","E1289");
         String test = empDAO.addEmployee(emp);

         assertSame("Employee added",test);




    }

    @Test
    void checkEmployeeByEmpNumber() {
        String empNo = "E1289";
        Boolean check = empDAO.checkEmployeeByEmpNumber(empNo);

        assertEquals(true,check);
    }
}