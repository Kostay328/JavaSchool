package ru.progwards.java1.lessons.bigints1;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {
    static BigDecimal fastPow(BigDecimal num, int pow) {
        BigDecimal res = num;

        for (int i = 0; i < pow - 1; i++) {
            res = res.multiply(num);
        }
        return res;
    }



    static BigInteger fibonacci(int n) {
        BigInteger[] arr = new BigInteger[n];
        arr[0] = BigInteger.valueOf(1);
        arr[1] = BigInteger.valueOf(1);
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }
        return arr[n-1];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        System.out.println(fibonacci(100));
        System.out.println(fastPow(BigDecimal.valueOf(2), 16));
        System.out.println(fastPow(BigDecimal.valueOf(3.4546754), 7));
    }
}
