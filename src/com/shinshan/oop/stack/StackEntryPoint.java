package com.shinshan.oop.stack;


public class StackEntryPoint {
    public static void main(String args[]) {
        Stackable<Employee> stackEmployees = new StackMakingArray<>();
        stackEmployees.push(new Employee(150_000_000, "20150911","표민수"));
        stackEmployees.push(new Employee(120_000_000, "20170212","표강수"));
        stackEmployees.push(new Employee(145_000_000, "20161112","표만수"));

        System.out.println("Top is :" + stackEmployees.peek());
        System.out.println("Item removed is : " + stackEmployees.pop());
        System.out.println("Stack Item Size: " + stackEmployees.size());
        System.out.println("Item removed is : " + stackEmployees.pop());
        System.out.println("Current Top is: " + stackEmployees.peek());
        stackEmployees.push(new Employee(175_000_000, "20090823","표준수"));
        System.out.println("Is Empty :  " + stackEmployees.isEmpty());
    }
}

