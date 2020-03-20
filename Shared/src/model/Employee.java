package model;

import java.io.Serializable;

public class Employee implements Serializable {
    private String empFirstName;
    private String empLastName;
    private String empNumber;

    public Employee(String empFirstName,String empLastName, String empNumber ) {
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empNumber = empNumber;
    }
    public Employee(){

    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    @Override
    public String toString() {
        return   empFirstName+" " + empLastName ;
    }
}
