package DB;

import model.EmployeeRes;

import java.util.List;

public interface IEmpResDAO {

    String addReservetion(EmployeeRes employeeRes);
    String cancelReservation(EmployeeRes employeeRes);
    List<EmployeeRes> reservationsByEmpNo(String empNo);
    List<EmployeeRes> allEmployeeReservations();
}
