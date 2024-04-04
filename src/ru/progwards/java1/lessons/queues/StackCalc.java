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
        StackCalc calc = new StackCalc();

        calc.push(2.2);
        calc.push(3);
        calc.push(12.1);
        calc.add();
        calc.mul();

        return calc.pop();
    }

    public static double calculation2() {
        StackCalc calc = new StackCalc();

        calc.push(737.22);
        calc.push(24);
        calc.add();
        calc.push(55.6);
        calc.push(12.1);
        calc.sub();
        calc.div();
        calc.push(19);
        calc.push(3.33);
        calc.sub();
        calc.push(87);
        calc.push(2);
        calc.push(13.001);
        calc.push(9.2);
        calc.sub();
        calc.mul();
        calc.add();
        calc.mul();
        calc.add();

        return calc.pop();
    }
}