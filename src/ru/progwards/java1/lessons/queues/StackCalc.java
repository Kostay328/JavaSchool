package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackCalc {
    private Deque<Double> stack;
    private double value;

    public StackCalc(){
        stack = new ArrayDeque<>();
    }

    public double getValue() {
        return value;
    }

    public void push(double value) {
        stack.push(value);
    }

    public double pop() {
        return stack.pop();
    }

    public void add() {
        stack.push(stack.pop() + stack.pop());
    }

    public void sub() {
        stack.push(-stack.pop() + stack.pop());
    }

    public void mul() {
        stack.push(stack.pop() * stack.pop());
    }

    public void div() {
        double d = stack.pop();
        stack.push(stack.pop() / d);
    }
}

class Calculate {
    public static double calculation1() {
        return 0;
    }

    public static double calculation2() {
        return 0;
    }
}