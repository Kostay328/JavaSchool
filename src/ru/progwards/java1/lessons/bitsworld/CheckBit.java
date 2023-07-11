package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
    public static int checkBit(byte value, int bitNumber) {
        byte b = 0b1000000;
        int f = value;
        int res = 0;
        for (int i = 0; i<bitNumber-1; i++) {
            f<<=1;
            res = (b & f) > 0 ? 1 : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(checkBit((byte) 0b1101111, 3));
    }
}
