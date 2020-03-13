package model;

import java.util.Date;

public class GuestRes {
    private String name;
    private String purpose;
    private Date date;
    private String resNo;


    public GuestRes(String name, String purpose, Date date, String resNo) {
        this.name = name;
        this.purpose = purpose;
        this.date = date;
        this.resNo = resNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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
