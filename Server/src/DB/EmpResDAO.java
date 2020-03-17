package DB;

import model.EmployeeRes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String cancelReservation(EmployeeRes employeeRes) {
        String sql ="DELETE FROM empres where empNo='"+employeeRes.getEmpNo()+"' AND Date='"+employeeRes.getDateFromPicker()+ "'";
        try {
            int numberOfDeletion= conn.delete(sql);
            if(numberOfDeletion ==0){

                return "cancellation failed";
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return "cancellation succeeded";
    }

    @Override
    public List<EmployeeRes> reservationsByEmpNo(String empNo) {
      String sql = "SELECT * FROM empres WHERE empno='"+empNo+"';";
        ArrayList<EmployeeRes>listOfReservations = new ArrayList<>();
        try {
            ResultSet rs = conn.query(sql);
            while(rs.next()){
                String date = rs.getDate("date").toString();
                String empNumber = rs.getString("empno");
                EmployeeRes employeeRes = new EmployeeRes(date,empNumber);
                listOfReservations.add(employeeRes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfReservations;
    }

    @Override
    public List<EmployeeRes> allEmployeeReservations() {
        String sql = "SELECT * FROM empres;";
        ArrayList<EmployeeRes>listOfReservations = new ArrayList<>();
        try {
            ResultSet rs = conn.query(sql);
            while(rs.next()){
                String date = rs.getDate("date").toString();
                String empNumber = rs.getString("empno");
                EmployeeRes employeeRes = new EmployeeRes(date,empNumber);
                listOfReservations.add(employeeRes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfReservations;
    }
}
