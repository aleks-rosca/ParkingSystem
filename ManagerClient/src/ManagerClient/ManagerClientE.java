package ManagerClient;

import Interface.IServer;
import model.Employee;
import model.EmployeeRes;

import java.rmi.RemoteException;
import java.util.List;

public class ManagerClientE implements IManagerClientE{
    private IServer sInterfaceM;
    public ManagerClientE(IServer s){
        sInterfaceM = s;
    }
    @Override
    public String addEmployee(Employee employee) {
        try {
            return sInterfaceM.getEmployeeServer().addEmployee(employee);
        } catch (RemoteException e) {
            return "Error";
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        try {
            return sInterfaceM.getEmployeeServer().getAllEmployees();
        } catch (RemoteException e) {

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String addEmployeeRes(EmployeeRes employeeRes) {
        try {
            return sInterfaceM.getEmployeeServer().addEmpRes(employeeRes);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }

    }

    @Override
    public List<EmployeeRes> getAllReservationByEmpNo(String empNo) {
        try {

            return sInterfaceM.getEmployeeServer().getEmpResByEmpNo(empNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<EmployeeRes> getAllEmpReservations() {
        try {
            return sInterfaceM.getEmployeeServer().getAllEmpReservations();
        } catch (RemoteException e) {

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        try {
            return sInterfaceM.getEmployeeServer().deleteEmpRes(employeeRes);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @Override
    public String deleteEmployee(Employee employee) {
        try {
            return sInterfaceM.getEmployeeServer().deleteEmployee(employee);
        } catch (RemoteException e) {

            e.printStackTrace();
            return "Error";
        }
    }

    @Override
    public String updateEmployee(Employee newEmployee, String empNo) {
        try {
            return sInterfaceM.getEmployeeServer().updateEmployee(newEmployee, empNo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
