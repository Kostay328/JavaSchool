package ru.progwards.java1.lessons.basics;

public class Distance3D {
    public static double distance(double x1, double y1,double z1, double x2, double y2, double z2){
        return Math.sqrt((x2 - x1)*2 + (y2 - y1)*2 + (z2 - z1)*2);
    }
}
