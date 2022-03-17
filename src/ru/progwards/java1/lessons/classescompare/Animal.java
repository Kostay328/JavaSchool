    package ru.progwards.java1.lessons.classescompare;

import java.util.Objects;

abstract public class Animal {
    String name;
    double weight;
    enum FoodKind {HAY, CORN}

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

    int compareTo(Animal animal){
        return Double.compare(weight, animal.getWeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Animal animal))
            return false;

        return Double.compare(animal.getWeight(), getWeight()) == 0 &&
                name.equals(animal.name) && animal.kind().equals(kind());
    }

    public Animal(String name){
        this.name = name;
    }
    abstract String kind();

    abstract String say();
    public String toString(){
        return "Это " + kind() + " " + name;
    }
}
