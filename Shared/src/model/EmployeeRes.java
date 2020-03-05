package model;

import java.util.Date;

public class EmployeeRes {
    private String dateFromPicker, empNo;
    public EmployeeRes(){

    }

    public void setDateFromPicker(String dateFromPicker) {
        this.dateFromPicker = dateFromPicker;
    }

    public String getDateFromPicker() {
        return dateFromPicker;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpNo() {
        return empNo;
    }
}
