package ru.progwards.java1.lessons.interfaces1;

public class Square implements Area{
    double segment;
    @Override
    public double getArea() {
        return segment*segment;
    }
    Square(double segment){
        this.segment = segment;
    }
}
