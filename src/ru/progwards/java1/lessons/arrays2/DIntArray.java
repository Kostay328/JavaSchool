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
        System.out.println(dir.at(0));
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
        int[] tmp = new int[array.length + 1];
        System.arraycopy(array,0,tmp,0,pos);
        tmp[pos-1] = num;
        System.arraycopy(array, pos, tmp, pos,array.length-pos);
        array = tmp;
    }
    public void atDelete(int pos){
        int[] tmp = new int[array.length - 1];
        System.arraycopy(array,0,tmp,0,pos);
        System.arraycopy(array, pos, tmp, pos,array.length-(pos+1));
        array = tmp;
    }
    public int at(int pos){
        return array[pos];
    }
}
