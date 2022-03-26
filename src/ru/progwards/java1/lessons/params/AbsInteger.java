package ru.progwards.java1.lessons.params;

public abstract class AbsInteger {
    public AbsInteger() {
    }
    static AbsInteger add(AbsInteger num1, AbsInteger num2){
        int res = Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
        if(res <= Byte.MAX_VALUE && res >= Byte.MIN_VALUE)
            return new ByteInteger((byte) res);
        else if(res <= Short.MAX_VALUE && res >= Short.MIN_VALUE)
            return new ShortInteger((short) res);
        else
            return new IntInteger(res);
    }
}
