package ru.progwards.java1.lessons.collections;

import java.util.*;

public class MatrixIterator<T> implements Iterator<T> {

    private T[][] array;
    private List<T> arr1D = new ArrayList<>();
    private int i = -1;

    MatrixIterator(T[][] array) {
        this.array = array;
        if (array.length != 0) {

            for (T[] o : array) {
                ArrayIterator<T> it = new ArrayIterator<>(o);
                while (it.hasNext()) {
                    arr1D.add(it.next());
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return i < arr1D.size() - 1;
    }

    @Override
    public T next() throws NoSuchElementException {

        try {
            i++;
            return arr1D.get(i);
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }
}
