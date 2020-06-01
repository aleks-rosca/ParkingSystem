package DB;

import model.Status;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO implements IStatusDAO {
    private final Conn conn;

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
    public List<Status> getAllStatuses() {
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

    @Override
    public int getNumberOfGuestsInParkingLot() {
        int occupiedSpots = 0;
        String sql = "SELECT COUNT(*) guest from parkinglot where type = 'G'";

        try {
            ResultSet rs = conn.query(sql);
            while(rs.next()){

                occupiedSpots = rs.getInt("guest");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }


        return occupiedSpots;

    }

    @Override
    public int getNumberOfEmployeesInParkingLot() {
        int occupiedSpots = 0;
        String sql = "SELECT COUNT(*) employee from parkinglot where type = 'E'";

        try {
            ResultSet rs = conn.query(sql);
            while(rs.next()){

                occupiedSpots = rs.getInt("employee");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }


        return occupiedSpots;
    }

    @Override
    public int getNumberOfPublicUsersInParkingLot() {
        int publicusers = 0;
        String sql = "SELECT COUNT(*) public from parkinglot where type = 'P'";

        try {
            ResultSet rs = conn.query(sql);
            while(rs.next()){

                publicusers = rs.getInt("public");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }


        return publicusers;
    }
}
