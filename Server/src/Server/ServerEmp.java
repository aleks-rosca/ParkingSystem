package Server;

import Interface.IServerMC;
import Model.ISModelE;
import Model.SModelE;
import model.Employee;
import model.EmployeeRes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServerEmp  implements IServerMC {
    private final ISModelE modelMc;


    public ServerEmp() throws RemoteException {
        modelMc = new SModelE();


        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void message(String msg) {
        System.out.println(msg);
    }

    @Override
    public String addEmployee(Employee employee) {
        return modelMc.addEmployee(employee);

    }

    @Override
    public String addEmpRes(EmployeeRes employeeRes) {
        return modelMc.addEmpRes(employeeRes);

    }


    @Override
    public List<EmployeeRes> getEmpResByEmpNo(String empNo) {
        return modelMc.getEmpResByEmpNo(empNo);
    }

    @Override
    public List<EmployeeRes> getAllEmpReservations() {
        return modelMc.getAllEmpReservation();
    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        return modelMc.deleteEmpRes(employeeRes);
    }


    @Override
    public List<Employee> getAllEmployees() {
        return modelMc.getAllEmployee();
    }

    @Override
    public String deleteEmployee(Employee employee) {
        return modelMc.deleteEmployee(employee);
    }

    @Override
    public String updateEmployee(Employee newEmployee, String empNo) {
        return modelMc.updateEmployee(newEmployee, empNo);
    }


}

