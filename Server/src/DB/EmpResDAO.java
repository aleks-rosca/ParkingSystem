package DB;

import model.EmployeeRes;

import java.sql.SQLException;

public class EmpResDAO implements IEmpResDAO
{
private Conn conn;
    public  EmpResDAO(){

         conn = Conn.getInstance();

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
