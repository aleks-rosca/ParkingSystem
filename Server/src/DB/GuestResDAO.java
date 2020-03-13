package DB;


import model.GuestRes;

public class GuestResDAO implements IGuestResDAO{
    private Conn conn;

    public GuestResDAO(){
        conn = Conn.getInstance();

    }

    @Override
    public String addGuestRes(GuestRes guestRes) {
        String sql = "INSERT INTO guestres values('"+guestRes.getDate()+"',"+guestRes.getResNo()+"',"
                +guestRes.getName()+"',"+guestRes.getPurpose()"';";

        return null;
    }
}
