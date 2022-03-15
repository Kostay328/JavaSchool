package ru.progwards.java1.lessons.inheritance;

public class Cow extends Animal{
    @Override
    String kind(){
        return "корова";
    }
    @Override
    String say(){
        return "мууууууу";
    }

    public Cow(String name) {
        super(name);
    }
}
