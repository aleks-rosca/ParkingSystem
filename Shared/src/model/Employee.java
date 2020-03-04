package model;

import java.io.Serializable;

public class Employee implements Serializable {
    private String empName = "";
    private String empNumber = "";

    public Employee(String empName, String empNumber) {
        this.empName = empName;
        this.empNumber = empNumber;
    }
    public Employee(){

    };

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empNumber='" + empNumber + '\'' +
                '}';
    }
}
