package com.shinshan.oop.thi;

class Circle2 {
    private double radius = 0;
    public Circle2 setRadius(double radius ){
        this.radius = radius;
        return this;
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
    public Circle2 display(){
        System.out.format("반지름 %.2f의 넓이는 %.2f 임! \n",
                radius, getArea());
        return this;
    }
}class ThisTest{
    public static void main(String args[]){
        Circle2 circle = new Circle2();
        circle.setRadius(2).display().setRadius(3).display();
    }
}

