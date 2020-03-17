package DB;


import model.GuestRes;

import java.sql.SQLException;

public class GuestResDAO implements IGuestResDAO{
    private Conn conn;

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



}
