package model;

public class Employee {
    private String empName;
    private String empNumber;

    public Employee(String empName, String empNumber){
        this.empName = empName;
        this.empNumber = empNumber;
    }

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
}
