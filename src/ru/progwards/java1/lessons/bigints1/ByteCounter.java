package ru.progwards.java1.lessons.bigints1;

public class ByteCounter extends Counter {
    public static void inc(Register value) {
        Counter.inc(value);
    }

    public static void dec(Register value) {
        Counter.dec(value);
    }
}
