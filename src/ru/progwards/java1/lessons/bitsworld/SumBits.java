package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    public static int sumBits(byte value) {
        byte b = (byte) 0b00000001;
        int f = value;
        int res = 0;
        for (int i = 0; i<8; i++) {
            res += (b & f) != 0 ? 1 : 0;
            f>>=1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sumBits((byte) 0b10110000));
    }
}
