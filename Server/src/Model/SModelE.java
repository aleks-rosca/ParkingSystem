package Model;

import DB.EmpDAO;
import DB.EmpResDAO;
import DB.IEmpDAO;
import DB.IEmpResDAO;
import model.Employee;
import model.EmployeeRes;

import java.util.List;

public class SModelE implements ISModelE {

    private IEmpDAO empdb;
    private IEmpResDAO empResDAO;


    public SModelE() {
        empdb = new EmpDAO();
        empResDAO = new EmpResDAO();
    }

    @Override
    public String addEmployee(Employee employee) {
        return empdb.addEmployee(employee);
    }

    @Override
    public String addEmpRes(EmployeeRes employeeRes) {
        return empResDAO.addReservetion(employeeRes);
    }

    @Override
    public List<EmployeeRes> getEmpResByEmpNo(String empNo) {
        return empResDAO.reservationsByEmpNo(empNo);
    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        return empResDAO.cancelReservation(employeeRes);
    }

    @Override
    public List<EmployeeRes> getAllEmpReservation() {
        return empResDAO.allEmployeeReservations();
    }


    @Override
    public List<Employee> getAllEmployee() {
        return empdb.getAllEmployees();
    }

    @Override
    public String deleteEmployee(Employee employee) {
        return empdb.deleteEmployee(employee);
    }

    @Override
    public String updateEmployee(Employee newEmployee, String empNo) {
        return empdb.updateEmployee(newEmployee, empNo);
    }


}

