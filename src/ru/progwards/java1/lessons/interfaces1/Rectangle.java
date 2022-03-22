package ru.progwards.java1.lessons.interfaces1;

public class Rectangle implements Area{
    double length;
    double width;

    @Override
    public double getArea() {
        return width*length;
    }
    Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }
}
