package DB;

import java.sql.SQLException;

public class PublicDAO implements IPublicDAO {
    private Conn conn;

    public PublicDAO() {

        conn = Conn.getInstance();
    }

    @Override
    public String PublicCheckIn(String licensePlateNo) {
        String sql = "INSERT INTO parkinglot VALUES('"+licensePlateNo+"','P',CURRENT_DATE);";

        try {
            conn.update(sql);
        } catch (SQLException e) {
            if(e.getSQLState().equals("23514")){
                return "No free spots";
            }else if(e.getSQLState().equals("23505")){

               return "Already checked in";
            }
            e.printStackTrace();
        }

        return "checked in to parking lot";
    }

    @Override
    public String PublicCheckOut(String licensePlateNo) {
        int delete = 0;
        String sql = "DELETE FROM parkinglot WHERE ID='"+licensePlateNo+"';";
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