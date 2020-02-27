package DB;

public class EmpDAO implements IEmpDAO {
    private Conn conn;

    public EmpDAO(Conn conn){

        this.conn = conn;
    }


    @Override
    public void addEmployee() {

    }
}
