package ru.progwards.java1.lessons.params;

public class ShortInteger extends AbsInteger{
    short s;

    public ShortInteger(short s) {
        this.s = s;
    }
    @Override
    public String toString() {
        return s+"";
    }
}
