package ru.progwards.java1.lessons.cycles;

public class GoldenFibo {
    public static int fiboNumber(int n){
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fiboNumber(n - 1) + fiboNumber(n - 2);
        }
    }
    public static boolean isGoldenTriangle(int a, int b, int c){
//        if(b == c)
//            return (((double)b+(double)c)/(double)a) >= 1.61703 && (((double)b+(double)c)/(double)a) <= 1.61903;
//        else if(a == c)
//            return (((double)a+(double)c)/(double)b) >= 1.61703 && (((double)a+(double)c)/(double)b) <= 1.61903;
//        else if(a == b)
            return (((double)a+(double)b)/(double)c) >= 1.61703 && (((double)a+(double)b)/(double)c) <= 1.61903;
    }

//    public static void main(String[] args){
//        int i = 0;
//        while (i++ < 15){
//            System.out.println(fiboNumber(i));
//            if ()
//            for (int l = 0; l < )
//        }
//    }
}
