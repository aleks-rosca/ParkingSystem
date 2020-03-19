package Model;

import model.Employee;
import model.EmployeeRes;
import model.GuestRes;

import java.util.List;

public interface IServerModel {
    String addEmployee(Employee employee);

    String addEmpRes(EmployeeRes employeeRes);

    String empCheckIn(String empNo);

    String empCheckOut(String empNo);

    String addGuestRes(GuestRes guestRes);

    String guestCheckIn(String resNo);

    String guestCheckOut(String resNo);

    List<EmployeeRes> getEmpRes(String empNo);

    String deleteEmpRes(EmployeeRes employeeRes);
}
