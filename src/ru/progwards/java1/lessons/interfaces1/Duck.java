package ru.progwards.java1.lessons.interfaces1;

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
    @Override
    public Color1 getColor() {
        return Color1.GRAY;
    }
}
