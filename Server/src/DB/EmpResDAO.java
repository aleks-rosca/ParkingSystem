package DB;

import model.Employee;
import model.EmployeeRes;

import java.sql.SQLException;

public class EmpResDAO implements IEmpResDAO
{
    private Conn conn;

    {
        try {
            conn = new Conn();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  EmpResDAO(){

        conn.getInstance();

    }

    @Override
    public String addReservetion(EmployeeRes employeeRes) {
        String sql = "insert into empres values('"+employeeRes.getDateFromPicker()+"','"+employeeRes.getEmpNo()+"');";
        try {
            conn.update(sql);
            return "Reservation is created";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Reservation is not created";
        }
    }
}
