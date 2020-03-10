package Test;

import Model.IMCEModel;
import Model.MCEModel;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MCEModelTest {
private String empNo1,empNo2,empName;
IMCEModel model = new MCEModel();
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        empNo1 = "E1234";
        empNo2 = "12345";
        empName = "jACeK";

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void checkFirstChar() {
       assertTrue(model.checkFirstChar(empNo1));
       assertFalse(model.checkFirstChar(empNo2));
    }

    @Test
    void rearrangeChars() {
        assertEquals("Jacek",model.rearrangeChars(empName));
    }
}