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
            digits[i] = Byte.parseByte(Character.toString(cl[i]));
    }

    @Override
    public String toString() {
        return Arrays.toString(digits)+"";
    }

    boolean add(ArrayInteger num){
        byte[] res = new byte[digits.length];
        if(num.digits.length > digits.length) {
            digits = new byte[0];
            return false;
        }
        byte plus = 0;
        try {
            for (int i = 0; i < num.digits.length; i++) {
                if ((num.digits[i] + digits[i] + plus) >= 10) {
                    res[i] = (byte) ((num.digits[i] + digits[i] + plus) - 10);
                    plus = 1;
                } else {
                    res[i] = (byte) (digits[i] + num.digits[i] + plus);
                    plus = 0;

                }
            }
        }catch (Exception e){
            digits = new byte[0];
            return false;

        }
        digits = res;
        return true;
    }

    public static void main(String[] args) {
        ArrayInteger a = new ArrayInteger(5);
        a.fromString("65490");
        ArrayInteger a1 = new ArrayInteger(5);
        a1.fromString("26761");
        a.add(a1);

        System.out.println(a);
    }
}
