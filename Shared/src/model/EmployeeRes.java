package model;

import java.util.Date;

public class EmployeeRes {
    private Date date;
    public EmployeeRes(Date date){
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
