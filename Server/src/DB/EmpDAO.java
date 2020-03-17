package DB;

import model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDAO implements IEmpDAO {
    private  Conn conn;



    public EmpDAO() {
     conn =    Conn.getInstance();

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

        String sql = "INSERT INTO employee values('" + employee.getEmpNumber() + "','" + employee.getEmpFirstName() + "','"+employee.getEmpLastName()+"');";
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
    public Employee getEmployeeByName(String firstName,String lastName) {
        return null;
    }

    @Override
    public String getEmployeeNameByEmpNo(String empNo) {
        String sql = "Select * from employee where empno='" + empNo + "';";
        String firstName=null;
        String lastName=null;
        try {
            ResultSet rs=conn.query(sql);
            while(rs.next()){
                firstName=rs.getString("firstName");
                lastName=rs.getString("lastName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return firstName+" "+lastName;
    }

}
