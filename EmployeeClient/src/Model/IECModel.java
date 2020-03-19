package Model;

import javafx.collections.ObservableList;
import model.EmployeeRes;

public interface IECModel {
    String addEmpRes(String dateFromPicker, String empNo);

    ObservableList<EmployeeRes> getEmpRes(String empNo);

    String deleteEmpRes(EmployeeRes employeeRes);
}
