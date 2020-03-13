package Model;

import model.Employee;
import model.EmployeeRes;
import model.GuestRes;

public interface IServerModel {
    String addEmployee(Employee employee);

    String addEmpRes(EmployeeRes employeeRes);

    String empCheckIn(String empNo);

    String empCheckOut(String empNo);

    String addGuestRes(GuestRes guestRes);
}
