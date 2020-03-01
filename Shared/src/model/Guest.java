package model;

public class Guest {
    private String name;
    private String purpose;

    public Guest(String name, String purpose){
        this.name = name;
        this.purpose = purpose;
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
}
