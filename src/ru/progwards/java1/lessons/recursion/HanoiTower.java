package ru.progwards.java1.lessons.recursion;

import java.util.*;

public class HanoiTower {
    int size;
    int pos;
    ArrayDeque<Integer> peg0 = new ArrayDeque<>();
    ArrayDeque<Integer> peg1 = new ArrayDeque<>();
    ArrayDeque<Integer> peg2 = new ArrayDeque<>();
    Map<Integer, ArrayDeque<Integer>> map = new HashMap<>();
    boolean trace;

    public HanoiTower(int size, int pos) {
        this.size = size;
        this.pos = pos;
        map.put(0, peg0);
        map.put(1, peg1);
        map.put(2, peg2);
        for (int i = size; i >= 1; i--) {
            map.get(pos).offerFirst(i);
        }
    }

    public void hanoiTower(int to) {
        if (to == pos || size == 0) return;
        if (size == 1) {
            map.get(to).offerFirst(Objects.requireNonNull(map.get(pos).poll()));
            return;
        }
        if (size % 2 == 1)
            move(pos, 3 - pos - to);
        else
            move(pos, to);
    }

    public void move(int from, int to) {
        int sparePeg = 3 - from - to;

        map.get(sparePeg).offerFirst(Objects.requireNonNull(map.get(from).poll()));
        print();
        map.get(to).offerFirst(Objects.requireNonNull(map.get(from).poll()));
        print();
        map.get(to).offerFirst(Objects.requireNonNull(map.get(sparePeg).poll()));
        print();

        if (peg0.size() == size || peg1.size() == size || peg2.size() == size)
            return;

        if (map.get(sparePeg).isEmpty() || (!map.get(from).isEmpty() && map.get(sparePeg).peekFirst() > map.get(from).peekFirst()))
            map.get(sparePeg).offerFirst(Objects.requireNonNull(map.get(from).poll()));
        else
            map.get(from).offerFirst(Objects.requireNonNull(map.get(sparePeg).poll()));
        print();
        move(to, sparePeg);
    }


    void print() {
        if (trace) {
            ArrayDeque<Integer> clone0 = peg0.clone();
            ArrayDeque<Integer> clone1 = peg1.clone();
            ArrayDeque<Integer> clone2 = peg2.clone();

            int[] arr0 = new int[size];
            int[] arr1 = new int[size];
            int[] arr2 = new int[size];

            for (int i = 0; i < size; i++) {
                arr0[i] = Optional.ofNullable(clone0.pollLast()).orElse(0);
                arr1[i] = Optional.ofNullable(clone1.pollLast()).orElse(0);
                arr2[i] = Optional.ofNullable(clone2.pollLast()).orElse(0);
            }

            for (int i = size - 1; i >= 0; i--) {
                System.out.println(numFormat(arr0[i]) + " " + numFormat(arr1[i]) + " " + numFormat(arr2[i]));
            }

            System.out.println("=================");
        }
    }

    private String numFormat(Integer n) {
        if (n == 0) return                  "  I  ";
        if (n > 0 && n < 10) return         "<00" + n + ">";
        if (n >= 10 && n < 100) return      "<0" + n + ">";
        if (n >= 100 && n < 1000) return    "<" + n + ">";
        return "<ovl>";
    }

    void setTrace(boolean on) {
        trace = on;
    }
}