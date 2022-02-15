package ru.progwards.java1.lessons.wrappers;

public class AccuracyDoubleFloat {
    public static Double volumeBallDouble(Double radius){
        return (4*3.14*radius*radius*radius)/3;
    }
    public static Float volumeBallFloat(Float radius){
        return (4F*3.14F*radius*radius*radius)/3F;
    }
    public static Double calculateAccuracy(Double radius){
        return volumeBallDouble(radius)-volumeBallFloat(Float.valueOf(Double.toString(radius))).doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(volumeBallDouble(6371.2));
        System.out.println(volumeBallFloat(6371.2F));
    }
}
