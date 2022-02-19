package ru.progwards.java1.lessons.compare;

public class TriangleInfo {
    public static boolean isTriangle(int a, int b, int c){
        return a < c+b && b < a+c && c < a+b;
    }
    public static boolean isRightTriangle(int a, int b, int c){
        return a*a+b*b == c*c || c*c+b*b == a*a || a*a+c*c == b*b;
    }
    public static boolean isIsoscelesTriangle(int a, int b, int c){
        return a==b||a==c||b==c;
    }
}
