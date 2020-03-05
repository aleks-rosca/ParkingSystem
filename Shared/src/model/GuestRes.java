package model;

import java.util.Date;

public class GuestRes {
    private Date date;
    private String resNo;

    public GuestRes(Date date, String resNo){
        this.date = date;
        this.resNo = resNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResNo() {
        return resNo;
    }

    public void setResNo(String resNo) {
        this.resNo = resNo;
    }
}
