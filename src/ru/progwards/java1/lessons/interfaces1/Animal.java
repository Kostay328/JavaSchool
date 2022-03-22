    package ru.progwards.java1.lessons.interfaces1;

import java.util.Objects;

abstract public class Animal implements IColor, Comparable<Animal>{
    String name;
    double weight;

    abstract public FoodKind getFoodKind();
    abstract public double getFoodCoeff();
    public double calculateFoodWeight(){
        return getFoodCoeff() * weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }

    public double calculateFoodPrice(){
        if(getFoodKind() == FoodKind.HAY)
            return weight*getFoodCoeff()*2;
        else
            return weight*getFoodCoeff()*15;
    }

    @Override
    public int compareTo(Animal animal){
        return Double.compare(weight, animal.getWeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.getWeight(), getWeight()) == 0 &&
                name.equals(animal.name) && animal.kind().equals(kind());    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getWeight());
    }

    public Animal(String name){
        this.name = name;
    }
    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    abstract String kind();

    abstract String say();
    public abstract Color1 getColor();
    public String toString(){
        return "Это " + kind() + " " + name + " " + weight + " " + getColor();
    }
}
