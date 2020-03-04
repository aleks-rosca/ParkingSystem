package DB;

import model.Employee;

import java.sql.SQLException;

public class EmpDAO implements IEmpDAO {
    private Conn conn;
    public EmpDAO()  {
        try {
            conn = new Conn();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public EmpDAO(Conn conn) {

        this.conn = conn;
    }


    @Override

    public boolean addEmployee(Employee employee) {
        boolean added = false;
        String sql = "INSERT INTO employee values('"+ employee.getEmpNumber()+ "','" + employee.getEmpName()+ "');";
        try {
            conn.update(sql);
            added = true;
        } catch (SQLException e) {
            if(e.getSQLState().equals("23505")){

            }
            e.printStackTrace();

        }
    return added;
}}
