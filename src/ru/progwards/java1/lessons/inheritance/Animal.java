package ru.progwards.java1.lessons.inheritance;

abstract public class Animal {
    String name;
    public Animal(String name){
        this.name = name;
    }
    abstract String kind();

    abstract String say();
    public String toString(){
        return "Это " + kind() + " " + name;
    }
}
