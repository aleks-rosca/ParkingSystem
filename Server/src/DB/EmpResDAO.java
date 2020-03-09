package DB;

import model.EmployeeRes;

import java.sql.SQLException;

public class EmpResDAO implements IEmpResDAO {
    private Conn conn;


    public EmpResDAO() {

        conn = Conn.getInstance();

    }

    @Override
    public String addReservetion(EmployeeRes employeeRes) {
        String sql = "insert into empres values('" + employeeRes.getDateFromPicker() + "','" + employeeRes.getEmpNo() + "');";
        try {
            conn.update(sql);

        } catch (SQLException e) {

            if(e.getSQLState().equals("23505")){
                return "Reservation is not created";
            }else if(e.getSQLState().equals("23514")){

                return "You can not create reservation for same day or more than 7 days ahead";
            }
            e.printStackTrace();
        }

        return "Reservation is created";
    }
}
