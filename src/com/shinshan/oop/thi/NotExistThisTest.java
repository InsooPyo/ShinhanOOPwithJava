package com.shinshan.oop.thi;

class Circle1 {
    private double radius = 0;
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public void display() {
        System.out.format("반지름 %.2f의 넓이는 %.2f 임! \n", radius, getArea());
    }
}
class NotExistThisTest {
    public static void main(String[] args) {
        Circle1 circle1 = new Circle1();
        Circle1 circle2 = new Circle1();
        circle1.setRadius(2);
        circle2.setRadius(3);
        circle1.display();
        circle2.display();
    }
}
