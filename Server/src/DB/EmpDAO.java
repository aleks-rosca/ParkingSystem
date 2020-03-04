package DB;

import model.Employee;

import java.sql.SQLException;

public class EmpDAO implements IEmpDAO {
    private Conn conn;
    public EmpDAO(){

    }

    public EmpDAO(Conn conn) {

        this.conn = conn;
    }


    @Override
    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employee values('"+ employee.getEmpNumber()+ "','" + employee.getEmpName()+ "');";
        try {
            conn.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
