package ru.progwards.java1.lessons.arrays2;

public class DIntArray {
    private int[] array = new int[0];

    public DIntArray() { }

    public static void main(String[] args) {
        DIntArray dir = new DIntArray();
        dir.add(89);
        dir.add(97);
        dir.add(-8);
        dir.add(70);
        dir.add(76);
        dir.add(19);
        dir.add(17);
        dir.add(-88);
        dir.add(-8);
        dir.add(60);
        dir.add(99);
        dir.add(68);
//        System.out.println(dir.at(0));
//        dir.atInsert(4, -11);
        System.out.println(dir.at(0));
        System.out.println(dir.at(1));
        System.out.println(dir.at(2));
        System.out.println(dir.at(3));
        System.out.println(dir.at(4));
        System.out.println(dir.at(5));
        System.out.println(dir.at(6));
        System.out.println(dir.at(7));
        System.out.println(dir.at(8));
        System.out.println(dir.at(9));
        System.out.println(dir.at(10));
        System.out.println(dir.at(11));
        dir.atDelete(8);
        System.out.println();
        System.out.println(dir.at(0));
        System.out.println(dir.at(1));
        System.out.println(dir.at(2));
        System.out.println(dir.at(3));
        System.out.println(dir.at(4));
        System.out.println(dir.at(5));
        System.out.println(dir.at(6));
        System.out.println(dir.at(7));
        System.out.println(dir.at(8));
        System.out.println(dir.at(9));
        System.out.println(dir.at(10));
//        System.out.println(dir.at(11));

    }

    public DIntArray(int[] array) {
        this.array = array;
    }

    public void add(int num){
        int[] tmp = new int[array.length + 1];
        System.arraycopy(array, 0, tmp, 0, array.length);
        tmp[array.length] = num;
        array = tmp;
    }
    public void atInsert(int pos, int num){
        int[] tmp = new int[array.length];
        System.arraycopy(array,0,tmp,0,pos);
        tmp[pos] = num;
        System.arraycopy(array, pos, tmp, pos+1,(array.length-pos)-1);
        array = tmp;
    }
    public void atDelete(int pos){
        int[] tmp = new int[array.length - 1];
        System.arraycopy(array,0,tmp,0,pos+1);
        System.arraycopy(array, pos+1, tmp, pos,(array.length-pos)-1);
        array = tmp;
    }
    public int at(int pos){
        return array[pos];
    }
}
