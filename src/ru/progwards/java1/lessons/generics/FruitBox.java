package ru.progwards.java1.lessons.generics;

import java.util.ArrayList;

public class FruitBox<E extends Fruit> extends ArrayList<Fruit> implements Comparable<FruitBox> {

    @Override
    public boolean add(Fruit f) {
        if (size() == 0 || get(0).getClass().equals(f.getClass()))
            return super.add(f);
        return false;
    }

    public float getWeight() {
        return size() > 0 ? size() * get(0).getWeight() : 0;
    }

    void moveTo(FruitBox<Fruit> fb) throws UnsupportedOperationException {
        try {
            if (get(0).getClass().equals(fb.get(0).getClass())) {
                fb.addAll(this);
                clear();
            } else {
                throw new UnsupportedOperationException();
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public int compareTo(FruitBox fb) {
        return Float.compare(getWeight(), fb.getWeight());
    }
}

abstract class Fruit {
    abstract float getWeight();
}

class Apple extends Fruit {
    @Override
    public float getWeight() {
        return 1f;
    }
}

class Orange extends Fruit {
    @Override
    public float getWeight() {
        return 1.5f;
    }
}