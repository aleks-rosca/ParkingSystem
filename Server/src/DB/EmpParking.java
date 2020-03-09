package DB;

import java.sql.SQLException;

public class EmpParking implements IEmpParking {
    private Conn conn;

    public EmpParking() {

        conn = Conn.getInstance();
    }

    @Override
    public String empCheckIn(String empNo) {
        String sql = "INSERT INTO parkinglot VALUES('"+empNo+"','E',CURRENT_DATE);";

        try {
            conn.update(sql);
        } catch (SQLException e) {
            if(e.getSQLState().equals("23505")){

                return "Already checked in";
            }else if(e.getSQLState().equals("P0001")){
                return "No such employee number";
            }
            e.printStackTrace();
        }

        return "checked in to parking lot";
    }
}
