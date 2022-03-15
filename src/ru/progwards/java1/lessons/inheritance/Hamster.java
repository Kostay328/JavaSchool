package ru.progwards.java1.lessons.inheritance;

public class Hamster extends Animal{
    @Override
    String kind(){
        return "хомяк";
    }
    @Override
    String say(){
        return "хрум-хрум-хрум";
    }

    public Hamster(String name) {
        super(name);
    }
}

