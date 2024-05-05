package ru.progwards.java1.lessons.recursion;

import java.util.ArrayDeque;

import static java.lang.String.format;

public class HanoiTower {
    final static int p3 = 3;
    int size;
    int pos;
    ArrayDeque<Integer>[] pin;
    boolean setTrace;

    public HanoiTower(int size, int pos) {
        setTrace = false;
        this.size = size;
        this.pos = pos;
        ArrayDeque<Integer> pin1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> pin2 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> pin3 = new ArrayDeque<Integer>();
        pin = new ArrayDeque[]{new ArrayDeque<Integer>(), new ArrayDeque<Integer>(), new ArrayDeque<Integer>()};
        for (int i = size; i>0; i--)
            pin[pos].addFirst(i);
    }

    void print() {
        Integer[][] ar2 = new Integer[p3][];
        for (int i = 0; i<p3; i++) {
            ArrayDeque<Integer> pinX = pin[i];
            Integer[] arrInt = pinX.toArray(new Integer[0]);
            ar2[i] = arrInt;
        }

        for (int i = 0; i<size; i++){
            StringBuilder line = new StringBuilder();
            for (int j = 0; j<p3; j++) {
                int shift = size - ar2[j].length;
                if (shift > i)
                    line.append("  I  ").append(" ");
                else
                    line.append(format("<%03d>", ar2[j][i - shift])).append(" ");
            }
            System.out.println(line.substring(0,line.length()-1));
        }
        System.out.println("=================");
    }

    void setTrace(boolean on){
        setTrace = on;
    }

    void moveStack(int from, int to, int count) {
        if (count > 0){
            int other = getIndex(from, to);
            moveStack(from, other,count-1);
            ArrayDeque<Integer> from_X = this.pin[from];
            ArrayDeque<Integer> to_X = this.pin[to];
            int top = from_X.pollFirst();
            to_X.addFirst(top);
            if (setTrace)
                this.print();
            moveStack(other,to,count-1);
        }
    }

    static int getIndex(int ind1, int ind2) {
        int res = 0;
        switch (ind1) {
            case 0:
                if (ind2 == 1) res = 2;
                else res = 1;
                break;
            case 1:
                if (ind2 == 2) res = 0;
                else res = 2;
                break;
            case 2:
                if (ind2 == 0) res = 1;
                else res = 0;
                break;
        }
        return res;
    }

    public void move(int from, int to){
        moveStack(from, to, this.size);
    }
}