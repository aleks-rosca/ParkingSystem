package model;


import java.io.Serializable;

public class EmployeeRes implements Serializable {
    private String dateFromPicker;
    private String empNo;

    public EmployeeRes(String dateFromPicker, String empNo){
        this.dateFromPicker = dateFromPicker;
        this.empNo = empNo;
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

    @Override
    public String toString() {
        return "EmployeeRes{" +
                "dateFromPicker='" + dateFromPicker + '\'' +
                ", empNo='" + empNo + '\'' +
                '}';
    }
}
