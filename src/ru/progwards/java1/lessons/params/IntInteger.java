package ru.progwards.java1.lessons.params;

public class IntInteger extends AbsInteger{
    int i;

    public IntInteger(int i) {
        this.i = i;
    }
    @Override
    public String toString() {
        return i+"";
    }
}
