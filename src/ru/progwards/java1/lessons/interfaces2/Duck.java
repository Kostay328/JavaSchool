package ru.progwards.java1.lessons.interfaces2;

public class Duck extends Animal {
    @Override
    String kind(){
        return "утка";
    }
    @Override
    String say(){
        return "кря-кря";
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return 0.04;
    }

    public Duck(String name) {
        super(name);
    }

    public Duck(String name, double weight) {
        super(name, weight);
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public String getHome(){
        return "ферма";
    }
}
