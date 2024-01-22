package com.shinshan.oop.emp;
class Employee {
    private float annualSalary;
    private String empName;
    public Employee() {
    }
    public Employee(float annualSalary, String empName) {
        this.annualSalary = annualSalary;
        this.empName = empName;
    }
    public float paycheck() {
        return annualSalary / 12;
    }
    public String getEmployeeName() {
        return empName;
    }
}
class EmployeeBasicMain {
    public static void main(String... args) {
        var emp = new Employee(150_000_000, "김신한");
        System.out.format("%s 님의 월급은 %.0f 입니다", emp.getEmployeeName(), emp.paycheck());
    }
}
