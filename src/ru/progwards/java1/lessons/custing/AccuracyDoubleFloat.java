package ru.progwards.java1.lessons.custing;

public class AccuracyDoubleFloat {
    public static double calculateAccuracy(){
        double d = 1d/3d;
        float f = Float.parseFloat(Double.toString(d));
        return d-Double.parseDouble(Float.toString(f));
    }
}
