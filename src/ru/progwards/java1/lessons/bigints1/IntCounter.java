package ru.progwards.java1.lessons.bigints1;

public class IntCounter extends Counter{
    public static void inc(Register value) {
        boolean signBefore = value.register[31].value;
        Counter.inc(value);
        if (!signBefore && value.register[31].value) {
            value.register[31].value = false;
        }
    }

    public static void dec(Register value) {
        boolean signBefore = value.register[31].value;
        Counter.dec(value);
        if (signBefore && !value.register[31].value) {
            value.register[31].value = true;
        }
    }
}
