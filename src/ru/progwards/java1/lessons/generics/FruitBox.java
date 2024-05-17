package ru.progwards.java1.lessons.generics;

import java.util.ArrayList;

public class FruitBox extends ArrayList<Fruit> {
    public boolean add(Fruit fruit) {
        if (size() == 0 || get(0).getClass().equals(fruit.getClass())) {
            super.add(fruit);
            return true;
        }else
            return false;
    }

    public double getWeight() {
        return stream().mapToDouble(Fruit::getWeight).sum();
    }

    public void moveTo(FruitBox otherBox) {
        if (otherBox != null && getClass().equals(otherBox.getClass())) {
            otherBox.clear();
            otherBox.addAll(this);
            clear();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}

abstract class Fruit {
    protected double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

class Apple extends Fruit {
    public Apple() {
        super(1.0);
    }
}

class Orange extends Fruit {
    public Orange() {
        super(1.5);
    }
}