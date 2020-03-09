package Model;

import EmployeeClient.IEmployeeClient;
import model.EmployeeRes;

public class ECModel implements IECModel {
    EmployeeRes employeeRes;
    private IEmployeeClient client;

    public ECModel(IEmployeeClient cl) {
        client = cl;
    }

    public String addEmpRes(String dateFromPicker, String empNo) {
        employeeRes = new EmployeeRes(dateFromPicker, empNo);
        return client.addReservationByEmp(employeeRes);
    }
}
