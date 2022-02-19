package ru.progwards.java1.lessons.compare;

public class TriangleSimpleInfo {
    public static int maxSide(int a, int b, int c){
        if(a >= b && a >= c)
            return a;
        else if(b >= a && b >= c)
            return b;
        else if(c >= a && c >= b)
            return c;
        else
            return a;
    }
    public static int minSide(int a, int b, int c){
        if(a <= b && a <= c )
            return a;
        else if(b <= a && b <= c)
            return b;
        else if(c <= a && c <= b)
            return c;
        else
            return a;
    }
    public static boolean isEquilateralTriangle(int a, int b, int c){
        return a == b && b == c;
    }

    public static void main(String[] args) {
        System.out.println(maxSide(5, 7, 7));
    }
}
