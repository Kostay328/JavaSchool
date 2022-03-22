package ru.progwards.java1.lessons.interfaces1;

public class Circle implements Area{
    double diameter;

    @Override
    public double getArea() {
        return Math.PI*diameter*diameter;
    }
    Circle(double diameter){
        this.diameter = diameter;
    }
}
