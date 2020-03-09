package test;

import DB.*;
import model.Employee;
import model.EmployeeRes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpParkingTest {
    private IEmpParking epark;
    private IEmpResDAO eres;
    private IEmpDAO empDAO;
    @BeforeEach
    void setUp() {
        eres = new EmpResDAO();
        epark = new EmpParking();
        empDAO = new EmpDAO();
        Employee emp = new Employee("testUser2", "E2222");
        empDAO.addEmployee(emp);
        EmployeeRes empres = new EmployeeRes("2020/03/10",emp.getEmpNumber());

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void empCheckIn() {
        String testcheckinEmp = epark.empCheckIn("E2222");
        assertSame("checked in to parking lot", testcheckinEmp);
    }
}