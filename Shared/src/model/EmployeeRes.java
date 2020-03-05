package model;


public class EmployeeRes {
    private String dateFromPicker;
    private Employee emp;
    public EmployeeRes(){

    }

    public void setDateFromPicker(String dateFromPicker) {
        this.dateFromPicker = dateFromPicker;
    }

    public String getDateFromPicker() {
        return dateFromPicker;
    }

    public void setEmpNo(String empNo) {
        emp.setEmpNumber(empNo);
    }

    public String getEmpNo() {
        return emp.getEmpNumber();
    }
    public String getEmpName() {
        return emp.getEmpName();
    }

    public Employee getEmp() {
        return emp;
    }

}
