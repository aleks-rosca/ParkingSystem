package Model;

import EmployeeClient.IEmployeeClient;
import model.EmployeeRes;

import java.util.*;

public class ECModel implements IECModel {
    EmployeeRes employeeRes;
    ArrayList<EmployeeRes> resList;
    private IEmployeeClient client;

    public ECModel(IEmployeeClient cl) {
        client = cl;
    }

    public String addEmpRes(String dateFromPicker, String empNo) {
        employeeRes = new EmployeeRes(dateFromPicker, empNo);
        return client.addReservationByEmp(employeeRes);
    }

    @Override
    public List<EmployeeRes> getEmpRes(String empNo) {
        resList = new ArrayList<>();

        return client.getEmpRes(empNo);
    }
}
