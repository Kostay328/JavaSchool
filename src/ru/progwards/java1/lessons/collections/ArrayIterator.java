package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int i = -1;

    @Override
    public T next() {
        i++;
        return array[i];
    }

    @Override
    public boolean hasNext() {
        return i < array.length - 1;
    }

    ArrayIterator(T[] array) {
        this.array = array;
    }
}