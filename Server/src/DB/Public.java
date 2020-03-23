package DB;

import java.sql.SQLException;

public class Public implements IPublic {
    private Conn conn;

    public Public() {

        conn = Conn.getInstance();
    }

    @Override
    public String PublicCheckIn(String licensePlateNo) {
        String sql = "INSERT INTO parkinglot VALUES('"+licensePlateNo+"','P',CURRENT_DATE);";

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