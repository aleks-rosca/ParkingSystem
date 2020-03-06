package model;


import java.io.Serializable;

public class EmployeeRes implements Serializable {
    private String dateFromPicker;
    private Employee employeeResModel;
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
        employeeResModel.setEmpNumber(empNo);
    }

    public String getEmpNo() {
        return empNo;
    }
    public String getEmpName() {
        return employeeResModel.getEmpName();
    }

    public Employee getEmp() {
        return employeeResModel;
    }

    @Override
    public String toString() {
        return "EmployeeRes{" +
                "dateFromPicker='" + dateFromPicker + '\'' +
                ", emp=" + employeeResModel +
                ", empNo='" + empNo + '\'' +
                '}';
    }
}
