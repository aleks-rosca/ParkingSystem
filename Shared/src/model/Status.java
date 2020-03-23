package model;

import java.io.Serializable;

public class Status implements Serializable {

    private int occupiedSpots;
    private String date;


    public Status(String date, int occupiedSpots) {
        this.occupiedSpots = occupiedSpots;
        this.date = date;
    }

    public int getOccupiedSpots() {
        return occupiedSpots;
    }

    public void setOccupiedSpots(int occupiedSpots) {
        this.occupiedSpots = occupiedSpots;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Status{" +
                "occupiedSpots=" + occupiedSpots +
                ", date='" + date + '\'' +
                '}';
    }
}
