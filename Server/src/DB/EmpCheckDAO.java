package DB;

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpCheckDAO implements IEmpCheckDAO {
    private Conn conn;

    public EmpCheckDAO() {

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

    @Override
    public String empCheckOut(String empNo) {
       String sql = "DELETE FROM parkinglot WHERE ID='"+empNo+"';";
        try {
            ResultSet rs=conn.query(sql);
            while(rs.next())
            {
                System.out.println(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "something went wront with check out";
        }
        return "checked out";
    }
}
