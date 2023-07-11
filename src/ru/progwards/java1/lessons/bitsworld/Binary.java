package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    byte num;

    public Binary(byte num) {
        this.num = num;
    }

    public String toString() {
        byte b = 0b1000000;
        int f = num;
        String res = "";
        for (int i = 0; i<7; i++) {
            res += (b & f) > 0 ? 1 : 0;
            f<<=1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Binary((byte) 107).toString());
    }
}
