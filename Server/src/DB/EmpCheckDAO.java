package DB;

import java.sql.SQLException;

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
            }else if(e.getSQLState().equals(("23514"))){
                return "no reservation or parkingspot";
            }
            e.printStackTrace();
        }

        return "checked in to parking lot";
    }

    @Override
    public String empCheckOut(String empNo) {
        int delete = 0;
       String sql = "DELETE FROM parkinglot WHERE ID='"+empNo+"';";
        try {
          delete  =conn.delete(sql);

        } catch (SQLException e) {
            e.printStackTrace();

        }
        if (delete==1){
            return "checked out";
        }else {
            return "something went wrong with check out";
        }

    }
}
