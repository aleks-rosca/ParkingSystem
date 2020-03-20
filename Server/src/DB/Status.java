package DB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Status implements IStatus {
    private Conn conn;

    public Status(){

       conn = Conn.getInstance();
    }

    @Override

    public int getCurrentStatus() {
     int occupiedSpots = 0;
    String sql = "SELECT occupiedspots from status where date = current_date";

        try {
            ResultSet rs = conn.query(sql);
            while(rs.next()){

                occupiedSpots = rs.getInt("occupiedspots");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }


        return occupiedSpots;
    }
}
