package model;


import java.io.Serializable;

public class EmployeeRes implements Serializable {
    private String dateFromPicker;
    private String empNo;
    private Employee employee;

    public EmployeeRes(String dateFromPicker, String empNo, Employee employee){

        this.dateFromPicker = dateFromPicker;
        this.empNo =empNo;
        this.employee = employee;
    }

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

    public Employee getEmployee() {
        return employee;
    }
//    @Override
//    public String toString() {
//        return "EmployeeRes{" +
//                "dateFromPicker='" + dateFromPicker + '\'' +
//                ", empNo='" + empNo + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "EmployeeRes{" +
                "dateFromPicker='" + dateFromPicker + '\'' +
                ", empNo='" + empNo + '\'' +
                ", employee=" + employee +
                '}';
    }
}
