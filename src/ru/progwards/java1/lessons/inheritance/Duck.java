package ru.progwards.java1.lessons.inheritance;

public class Duck extends Animal{
    @Override
    String kind(){
        return "утка";
    }
    @Override
    String say(){
        return "кря-кря";
    }

    public Duck(String name) {
        super(name);
    }
}
