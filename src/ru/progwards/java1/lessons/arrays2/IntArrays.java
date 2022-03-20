package ru.progwards.java1.lessons.arrays2;

import java.util.Arrays;

public class IntArrays {
    public static String toString(int []a){
        String res = "[";
        int i = 0;
        for (; i < a.length - 1; i++)
            res += a[i] + ", ";
        res += a[i+1] + "]";
        return res;
    }

    public static int[] bubble(int[] a) {
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < a.length-1; i++) {
                if(a[i] > a[i+1]){
                    isSorted = false;
                    buf = a[i];
                    a[i] = a[i+1];
                    a[i+1] = buf;
                }
            }
        }
        return a;
    }

    public static boolean equals1(int[] a1, int[] a2){
        try{
            for(int i = 0; i < a1.length; i++)
                if(a1[i] != a2[i])
                    return false;
        }catch (Exception e){}
        return true;
    }

    public static boolean equals2(int[] a1, int[] a2) {
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
}

