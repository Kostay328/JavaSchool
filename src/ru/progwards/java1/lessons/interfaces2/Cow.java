package ru.progwards.java1.lessons.interfaces2;

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

    public Cow(String name, double weight) {
        super(name, weight);
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public String getHome(){
        return "ферма";
    }

}
