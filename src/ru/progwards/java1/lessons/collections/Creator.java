package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Creator {
    public static Collection<Integer> fillEven(int n) {
        Collection<Integer> list = new ArrayList<>();
        int lim = n * 2;
        for (int i = 2; i <= lim; i += 2)
            list.add(i);
        return list;
    }

    public static Collection<Integer> fillOdd(int n) {
        List<Integer> list = new ArrayList<>();
        int lim = n * 2;
        for (int i = 1; i < lim; i += 2)
            list.add(0, i);
        return list;
    }

    public static Collection<Integer> fill3(int n) {
        Collection<Integer> list = new ArrayList<>();
        int lim = n * 3;
        for (int i = 0; i < lim; i += 3) {
            list.add(i);
            list.add(i * i);
            list.add(i * i * i);
        }
        return list;
    }
}