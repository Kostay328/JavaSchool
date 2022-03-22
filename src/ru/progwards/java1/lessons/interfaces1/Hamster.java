package ru.progwards.java1.lessons.interfaces1;

public class Hamster extends Animal {
    @Override
    String kind(){
        return "хомяк";
    }
    @Override
    String say(){
        return "хрум-хрум-хрум";
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return 0.06;
    }

    public Hamster(String name) {
        super(name);
    }
    @Override
    public Color1 getColor() {
        return Color1.BEIGE;
    }
}

