package DB;

import model.Employee;
import model.EmployeeRes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDAO implements IEmpDAO {
    private  static Conn conn;
    public EmpDAO()  {
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

  public static Conn getInstancce(){

      if(conn==null){
          try {
              conn = new Conn();

          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }
      }
      return conn;
  }

    @Override

    public boolean addEmployee(Employee employee) {
        boolean added = false;
        String sql = "INSERT INTO employee values('"+ employee.getEmpNumber()+ "','" + employee.getEmpName()+ "');";
        try {
            conn.update(sql);
            added = true;
        } catch (SQLException e) {
            if(e.getSQLState().equals("23505")){

            }
            e.printStackTrace();

        }
    return added;
}

    @Override
    public Employee getEmployeeByEmpNumber(String empnumber) {
        Employee employee=null;
        employee.setEmpNumber(empnumber);
      String sql = "Select * from employee where empno="+empnumber+";";
        try {
            ResultSet rs=conn.query(sql);
            while (rs.next())
            {
                employee.setEmpName(rs.getNString("empname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return employee;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return null;
    }

    @Override
    public void addReservetion(Employee employee, EmployeeRes employeeRes) {

    }

}
