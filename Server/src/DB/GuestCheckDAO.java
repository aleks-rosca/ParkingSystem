package DB;

import java.sql.SQLException;

public class GuestCheckDAO implements IGuestCheckDAO{

    private Conn conn;

    public GuestCheckDAO() {

        conn = Conn.getInstance();
    }

    @Override
    public String guestCheckIn(String resNo) {
        String sql = "INSERT INTO parkinglot VALUES('"+resNo+"','G',CURRENT_DATE);";

        try {
            conn.update(sql);
        } catch (SQLException e) {
            if(e.getSQLState().equals("P0001")){
                return "No such reservation number";
            }
            e.printStackTrace();
        }

        return "checked in to parking lot";
    }

    @Override
    public String guestCheckOut(String resNo) {
        int delete = 0;
        String sql = "DELETE FROM parkinglot WHERE ID='"+resNo+"';";
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
