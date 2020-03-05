package DB;

import model.Employee;
import model.EmployeeRes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDAO implements IEmpDAO {
    private static Conn conn;

    public EmpDAO() {
        getInstancce();
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

    public static Conn getInstancce() {

        if (conn == null) {
            try {
                conn = new Conn();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    @Override

    public String addEmployee(Employee employee) {

        String sql = "INSERT INTO employee values('" + employee.getEmpNumber() + "','" + employee.getEmpName() + "');";
        try {
            conn.update(sql);

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                return "Dublicate key";
            }
            e.printStackTrace();

        }
        return "Employee added";
    }

    @Override
    public boolean checkEmployeeByEmpNumber(String empnumber) {
        boolean exists=false;
        String sql = "Select * from employee where empno='" + empnumber + "';";
        try {
            ResultSet rs = conn.query(sql);
            while (rs.next()) {
                exists=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return null;
    }

}
