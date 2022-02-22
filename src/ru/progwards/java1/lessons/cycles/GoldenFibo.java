package ru.progwards.java1.lessons.cycles;

import javax.xml.transform.TransformerException;

public class GoldenFibo {
    public static int fiboNumber(int n){
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fiboNumber(n - 1) + fiboNumber(n - 2);
        }
    }
    public static boolean isGoldenTriangle(int a, int b, int c){
        if(b == c)
            return (((double)a+(double)c)/(double)c) >= 1.61703 && (((double)a+(double)c)/(double)c) <= 1.61903;
        else if(a == c)
            return (((double)b+(double)c)/(double)a) >= 1.61703 && (((double)b+(double)c)/(double)a) <= 1.61903;
        else if(a == b)
            return (((double)a+(double)c)/(double)b) >= 1.61703 && (((double)a+(double)c)/(double)b) <= 1.61903;
        return false;
    }



    class Triangle {
        double a;
        double b;
        double c;

        Triangle(double sa, double sb, double sc) {
            a = sa;
            b = sb;
            c = sc;
        }
    }
    Triangle t1 = new Triangle(2.0, 2.0, 3.0);
    Triangle t2 = new Triangle(2.5, 3.6, 5.1);
    Triangle t3 = new Triangle(5, 6, 7);

//    public static void main(String[] args){
//        int i = 0;
//        while (i++ < 15){
//            System.out.println(fiboNumber(i));
//            if ()
//            for (int l = 0; l < )
//        }
//    }
}
