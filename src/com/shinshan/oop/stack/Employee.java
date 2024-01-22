package com.shinshan.oop.stack;

import java.util.Objects;

public class Employee {
    private long salary;
    private String employeeID;
    private String employeeName;

    public Employee(long salary, String employeeID, String employeeName) {
        this.salary = salary;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
    }
    public String getEmployeeID(){
        return employeeID;
    }
    public long getSalary(){
        return salary;
    }
    @Override
    public String toString() {
        return String.format("%s 님의 ID는 %s 이고 연봉은 %d",employeeName, employeeID, salary );
    }
    @Override
    public boolean equals(Object employee) {
        boolean resultFlag = false;
        if(employee instanceof Employee){
            resultFlag = employeeID.equals(((Employee) employee).getEmployeeID());
        }
        return resultFlag;
    }
    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }
}

