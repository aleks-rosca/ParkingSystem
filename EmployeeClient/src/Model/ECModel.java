package Model;

import EmployeeClient.IEmployeeClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EmployeeRes;

import java.util.*;

public class ECModel implements IECModel {
    EmployeeRes employeeRes;
    ArrayList<EmployeeRes> resList;
    private final IEmployeeClient client;

    public ECModel(IEmployeeClient cl) {
        client = cl;
    }

    public String addEmpRes(String dateFromPicker, String empNo) {
        employeeRes = new EmployeeRes(dateFromPicker, empNo);
        return client.addReservationByEmp(employeeRes);
    }

    @Override
    public ObservableList<EmployeeRes> getEmpRes(String empNo) {
      ObservableList<EmployeeRes> empreslist;

        empreslist = FXCollections.observableArrayList( client.getEmpRes(empNo));

        return empreslist;
    }

    @Override
    public String deleteEmpRes(EmployeeRes employeeRes) {
        return client.deleteEmpRes(employeeRes);
    }
}
