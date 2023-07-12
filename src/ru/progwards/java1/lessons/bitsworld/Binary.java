package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    byte num;

    public Binary(byte num) {
        this.num = num;
    }

    public String toString() {
        byte b = (byte) 0b00000001;
        int f = num;
        String res = "";
        for (int i = 0; i<8; i++) {
            res = ((b & f) > 0 ? 1 : 0) + res;
            f>>=1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Binary((byte) 0b01000001).toString());
    }
}
