package ru.progwards.java1.lessons.bigints1;

public class ByteRegister {
    Bit[] myByte;

    public ByteRegister() {
        Bit[] res = new Bit[8];

        for (int i = 0; i < res.length; i++) {
            res[i] = new Bit();
        }
        myByte = res;
    }

    public ByteRegister(byte value) {
        String[] byteList = Integer.toString(value, 2).split("");

        Bit[] res = new Bit[byteList.length];

        for (int i = 0; i < byteList.length; i++) {
            res[i] = new Bit(byteList[i].equals("1"));
        }
        myByte = res;
    }

    @Override
    public String toString() {
        String res = "";

        for (Bit bit:myByte) {
            res += bit;
        }
        return res;
    }

    public String toDecString() {
        int result = 0;
        int mult = 1;
        for (int i = myByte.length-1; i >= 0; i--) {
            System.out.println(myByte[i]);
            if (myByte[i].toString().equals("1")) {
                result += mult;
            }
            mult *= 2;
        }
        return Integer.toString(result);
    }

    public static void main(String[] args) {
        System.out.println(new ByteRegister((byte) 100).toDecString());
    }
}
