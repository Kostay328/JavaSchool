package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
    public static int checkBit(byte value, int bitNumber) {
        byte b = 0b0000001;
        int f = value;
        int res = 0;
        for (int i = 0; i<(7-bitNumber); i++) {
            res = (b & f) > 0 ? 1 : 0;
            f >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(checkBit((byte)-51, 1));
        System.out.println(checkBit((byte) 71, 0));
        System.out.println(checkBit((byte) 0b1110010, 3));
    }
}
