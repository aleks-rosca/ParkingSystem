package DB;

import model.Status;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO implements IStatusDAO {
    private Conn conn;

    public StatusDAO(){

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

    @Override
    public List<Status> getAllStatues() {
        ArrayList<Status> allStatues = new ArrayList<>();

        String sql = "SELECT * FROM status";

        try {
            ResultSet rs =conn.query(sql);
            while (rs.next()){

              String date = rs.getDate("date").toString();
              int occupiedSpots = rs.getInt("occupiedspots");
              allStatues.add(new Status(date,occupiedSpots));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allStatues;
    }
}