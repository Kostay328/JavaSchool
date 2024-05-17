package ru.progwards.java1.lessons.generics;

import java.util.Arrays;

public class DynamicArray<T> {
    private T[] array;
    private int size;

    public DynamicArray() {
        this(2);
    }

    public DynamicArray(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
        size = 0;
    }

    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    public void insert(int pos, T element) {
        ensureCapacity();
        if (pos < 0 || pos > size) {
            throw new RuntimeException();
        }
        System.arraycopy(array, pos, array, pos + 1, size - pos);
        array[pos] = element;
        size++;
    }

    public T get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new RuntimeException();
        }
        return array[pos];
    }

    public void remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new RuntimeException();
        }
        System.arraycopy(array, pos + 1, array, pos, size - pos - 1);
        size--;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    public static void main(String[] args) {
        DynamicArray<Integer> da = new DynamicArray<>();
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(222);
        for (int i = 0; i < da.size(); i++) System.out.println(da.get(i));

        da.insert(0, 5);
        da.insert(2, 4);

        for (int i = 0; i < da.size(); i++) System.out.println(da.get(i));
        System.out.println("\nDynarray size = " + da.size() + "\n");
        da.get(25);
        da.remove(3);
        for (int i = 0; i < da.size(); i++) System.out.println(da.get(i));
    }
}