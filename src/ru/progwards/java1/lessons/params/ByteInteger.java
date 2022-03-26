package ru.progwards.java1.lessons.params;

public class ByteInteger extends AbsInteger{
    byte b;

    public ByteInteger(byte b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return b+"";
    }
}
