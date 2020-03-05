package Model;

import DB.EmpDAO;
import DB.IEmpDAO;
import model.Employee;

public class Model {
    private IEmpDAO empdb;


    public Model(){
        empdb = new EmpDAO();
    }
    public String addEmployee(Employee employee){
       return empdb.addEmployee(employee);
    }
}
