package ru.progwards.java1.lessons.wrappers;

public class StringConverter {
    public static Double volumeBallDouble(Double radius){
        return (4/3)*3.14*(radius*radius*radius);
    }
    public static Float volumeBallFloat(Float radius){
         return 4F/(3F*3.14F)*radius*radius*radius;
    }
    public static Double calculateAccuracy(Double radius){
         return volumeBallDouble(radius)-volumeBallFloat(Float.valueOf(Double.toString(radius))).doubleValue();
    }
}
