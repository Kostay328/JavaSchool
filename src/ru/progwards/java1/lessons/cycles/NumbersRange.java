package ru.progwards.java1.lessons.cycles;

public class NumbersRange {
    public static long sumNumbers(int start, int finish){
        int res = 0;
        for (int i = start; i < finish; i++) {
            res += i;
        }
        return res;
    }

    public static long sumOdd(int start, int finish){
        int res = 0;
        for (int i = start; i < finish; i++) {
            if(i % 2 == 0)
                res += i;
        }
        return res;
    }
    public static long sumEvenIdx(int start, int finish){
        int res = 0;
        for (int i = start; i < finish; i++) {
            if(i % 2 > 0)
                res += i;

        }
        return res;
    }
}
