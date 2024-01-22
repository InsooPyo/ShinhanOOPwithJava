package com.shinshan.oop.reflection;

import java.lang.Class;
import java.lang.reflect.*;

class Employee {
    private String empName;
    private long salary;
    public Employee(String empName, long salary) {
        this.empName = empName;
        this.salary = salary;
    }
    private long paycheck() {
        return salary / 12;
    }
    @Override
    public String toString() {
        return String.format("%s 님의 월급은 %d ", empName, paycheck());
    }
}
class RefectionExample {
    public static void main(String[] args) {
        try {
            Employee emp = new Employee("김신한", 90000000);
            Class<? extends Employee> empObj = emp.getClass();
            Method[] empRefMethods = empObj.getDeclaredMethods();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            for (Method refMethod : empRefMethods) {
                System.out.format("Method Name: %s, ", refMethod.getName());
                int modifier = refMethod.getModifiers();
                System.out.format("Modifier: %s, ", Modifier.toString(modifier));
                System.out.format("Return Types: %s \n", refMethod.getReturnType().getTypeName());
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            Field salaryRefField = Employee.class.getDeclaredField("salary");
            salaryRefField.setAccessible(true);
            //동적 필드 세팅
            salaryRefField.set(emp, 120000000);

            //salary 필드 리플렉션 객체를 얻어온다
            long typeValue = (long) salaryRefField.get(emp);
            System.out.format("Value: %d , ", typeValue);

            // salary 필드의 접근 지정자
            int fieldModifiers = salaryRefField.getModifiers();
            String modifierName = Modifier.toString(fieldModifiers);
            System.out.format("  salary 필드의 접근 지정자는 %s  \n", modifierName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
