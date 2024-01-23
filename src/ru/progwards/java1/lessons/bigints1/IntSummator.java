package ru.progwards.java1.lessons.bigints1;

public class IntSummator extends Summator{
    public static void add(IntRegister value1, IntRegister value2) {
        Summator.add(value1, value2);
    }

    public static void sub(IntRegister value1, IntRegister value2) {
        Summator.sub(value1,value2);
    }
}
