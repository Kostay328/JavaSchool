package ru.progwards.java1.lessons.basics;

public class Distance3D {
    public static void main(String[] args) {
        System.out.println(distance(93.11852649640434,75.08130403363963,28.106839918426758,75.08130403363963,75.08130403363963,7.723395780017415));
    }
    public static double distance(double x1, double y1,double z1, double x2, double y2, double z2){
        return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2) + (z1 - z2)*(z1 - z2));
    }
}
