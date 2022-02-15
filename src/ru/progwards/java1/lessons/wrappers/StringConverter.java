package ru.progwards.java1.lessons.wrappers;

public class StringConverter {
    public static String fromByte(byte number){
        return Byte.toString(number);
    }
    public static String fromShort(short number){
        return Short.toString(number);
    }
    public static String fromInt(int number){
        return Integer.toString(number);
    }
    public static String fromLong(long number){
        return Long.toString(number);
    }
    public static String fromFloat(float number){
        return Float.toString(number);
    }
    public static String fromDouble(double number){
        return Double.toString(number);
    }

}
