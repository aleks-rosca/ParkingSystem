package model;

import java.util.Date;

public class EmployeeRes {
    private String date;
    private int empNo;

    public EmployeeRes(String date, int empNo) {

        this.date = date;
        this.empNo = empNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
}
