package ru.progwards.java1.lessons.interfaces2;

public class Car implements CompareWeight{
    private double weight;

    public Car(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Это автомобиль грузоподъемностью " + weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeight) {
        if(Double.compare(this.getWeight(), smthHasWeight.getWeight()) < 0)
            return CompareResult.LESS;
        if(Double.compare(this.getWeight(), smthHasWeight.getWeight()) > 0)
            return CompareResult.GREATER;
        return CompareResult.EQUAL;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
