package ru.progwards.java1.lessons.params;

import java.util.Arrays;

public class ArrayInteger {
    byte[] digits;

    ArrayInteger(int n){
        digits = new byte[n];
    }

    void fromString(String value){
        String reversed = new StringBuffer(value).reverse().toString();
        char[] cl = reversed.toCharArray();
        for (int i = 0; i < cl.length; i++)
            digits[i] = (byte)cl[i];
    }

    @Override
    public String toString() {
        return Arrays.toString(digits)+"";
    }

    boolean add(ArrayInteger num){
        if(num.digits.length > digits.length) {
            digits = new byte[0];
            return false;
        }
        byte plus = 0;
        try {
            for (int i = 0; i < num.digits.length; i++) {
                if ((num.digits[i] + digits[i] + plus) > 10) {
                    digits[i] = (byte) (10 - (num.digits[i] + digits[i]));
                    plus = 1;
                } else {
                    plus = 0;
                    digits[i] = (byte) (digits[i] + num.digits[i]);
                }
            }
        }catch (Exception e){
            digits = new byte[0];
            return false;

        }
        return true;
    }
}
