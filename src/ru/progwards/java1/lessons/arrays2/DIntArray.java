package ru.progwards.java1.lessons.arrays2;

import java.util.Arrays;

public class DIntArray {
    private int[] array;

    public DIntArray() {
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
