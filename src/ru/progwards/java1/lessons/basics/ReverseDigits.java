package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static int reverseDigits(int number){
        int res = 0;

        while(number != 0) {
            int digit = number % 10;
            res = res * 10 + digit;
            number /= 10;
        }

        return res;
    }
}
