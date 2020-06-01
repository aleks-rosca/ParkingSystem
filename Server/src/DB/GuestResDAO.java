package DB;


import model.GuestRes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestResDAO implements IGuestResDAO{
    private final Conn conn;

    public GuestResDAO(){
        conn = Conn.getInstance();

    }

    @Override
    public String addGuestRes(GuestRes guestRes) {
        String sql = "INSERT INTO guestres values('"+guestRes.getDate()+"','"+guestRes.getResNo()+"','"
                +guestRes.getName()+"','"+guestRes.getPurpose()+"');";
        try {
            conn.update(sql);

        } catch (SQLException e) {

            if(e.getSQLState().equals("23505")){
                return "Reservation for guest is not created";
            }else if(e.getSQLState().equals("23514")){

                return "You can not create reservation";
            }
            e.printStackTrace();
        }

        return "Reservation for guest is created";
    }

    @Override
    public String cancelGuestRes(String resNo) {
        String sql= "DELETE FROM guestres WHERE resNo='"+resNo+"';";
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
    public List<GuestRes> getAllGuestReserevation() {
        String sql = "SELECT * FROM guestres;";
        ArrayList<GuestRes> listOfReservations = new ArrayList<>();
        try {
            ResultSet rs = conn.query(sql);
            while(rs.next()){
                String name = rs.getString("guestname");
                String date = rs.getDate("date").toString();
                String resNumber = rs.getString("resno");
                String purpose = rs.getString("guestpurpose");
                GuestRes guestRes = new GuestRes(name,purpose,date,resNumber);
                listOfReservations.add(guestRes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfReservations;
    }


}
