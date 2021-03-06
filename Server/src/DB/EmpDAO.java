package DB;

import model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO implements IEmpDAO {
    private final Conn conn;


    public EmpDAO() {
        conn = Conn.getInstance();

    }

  /*  public EmpDAO(Conn conn) {
        if (conn == null) {
            try {
                conn = new Conn();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //this.conn = conn;
        }
    }
*/


    @Override

    public String addEmployee(Employee employee) {

        String sql = "INSERT INTO employee values('" + employee.getEmpNumber() + "','" + employee.getEmpFirstName() + "','" + employee.getEmpLastName() + "');";
        try {
            conn.update(sql);

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                return "Duplicate key";
            }
            e.printStackTrace();

        }
        return "Employee added";
    }

    @Override
    public boolean checkEmployeeByEmpNumber(String empnumber) {
        boolean exists = false;
        String sql = "Select * from employee where empno='" + empnumber + "';";
        try {
            ResultSet rs = conn.query(sql);
            while (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }





    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM  employee;";
        ArrayList<Employee> listOfEmployees = new ArrayList<>();
        try {
            ResultSet rs = conn.query(sql);
            while (rs.next()) {
                String empNumber = rs.getString("empno");
                String firstName = rs.getString("empfirstname");
                String lastName = rs.getString("emplastname");
                Employee emp = new Employee(firstName, lastName, empNumber);

                listOfEmployees.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfEmployees;
    }

    @Override
    public String deleteEmployee(Employee employee) {

        String sql = "Delete from employee where empno='" + employee.getEmpNumber() + "';";

        try {
            int numberOfDeletion = conn.delete(sql);
            if (numberOfDeletion == 0) {

                return "deletion failed";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "deletion success";

    }

    @Override
    public String updateEmployee(Employee newEmployee, String empNo) {

        String sql = "update employee set empfirstname ='" + newEmployee.getEmpFirstName() + "', emplastname='" + newEmployee.getEmpLastName() +
                "', empno='" + newEmployee.getEmpNumber() + "' where  empno='" + empNo + "'";
        try {
            conn.update(sql);
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
            return "failed to update";

        }


    }
}
