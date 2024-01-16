package ru.progwards.java1.lessons.bigints1;

public class Bit {
    boolean value;

    public Bit() {

    }

    public Bit(boolean value) {
        this.value = value;
    }

    public String toString() {
        return value ? "1" : "0";
    }
}
