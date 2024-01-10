package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
    public static int checkBit(byte value, int bitNumber) {
        byte b = -127;
        int f = value;
        f >>= bitNumber;
        System.out.println(f);
        return (b & f) > 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(checkBit((byte) 5, 0));//1
        System.out.println(checkBit((byte) 114, 3));//0
        System.out.println(checkBit((byte) -51, 1));//0
        System.out.println(checkBit((byte) 71, 1));//0
        System.out.println(checkBit((byte) -127, 7));//1
        System.out.println(checkBit((byte) 3, 0));//1
    }
}
