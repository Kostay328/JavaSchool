package ru.progwards.java1.lessons.generics;

public class ArraySort {
    public static <T extends Object & Comparable<? super T>> void sort(T... arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i].compareTo(arr[j]) >= 1) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
    }
}
