package ru.progwards.java1.lessons.classescompare;

public class Cow extends Animal {
    @Override
    String kind(){
        return "корова";
    }
    @Override
    String say(){
        return "мууууууу";
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.HAY;
    }

    @Override
    public double getFoodCoeff() {
        return 0.05;
    }

    public Cow(String name) {
        super(name);
    }
}
