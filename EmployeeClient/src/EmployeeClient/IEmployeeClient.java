package EmployeeClient;

import model.EmployeeRes;

import java.util.List;

public interface IEmployeeClient {
    String addReservationByEmp(EmployeeRes employeeRes);
    List<EmployeeRes> getEmpRes(String empNo);
    String deleteEmpRes(EmployeeRes employeeRes);
}
