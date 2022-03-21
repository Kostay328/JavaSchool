package ru.progwards.java1.lessons.arrays2;

import java.util.Arrays;

public class DIntArray {
    private int[] array;

    public DIntArray(int[] array) {
        this.array = array;
    }

    public void add(int num){
        int[] tmp = new int[array.length];
        System.arraycopy(array, 0, tmp, 0, array.length);
        tmp[array.length] = num;
        array = tmp;
    }
    public void atInsert(int pos, int num){
        int[] tmp = new int[array.length + 1];
        System.arraycopy(array,0,tmp,0,pos);
        tmp[pos-1] = num;
        System.arraycopy(array, pos, tmp, pos,array.length-pos);
//        int[] tmp = new int[array.length];
//        for (Integer i = 0; array.length > i; i++) {
//            int posCompare = i.compareTo(pos);
//            if(posCompare == 0)
//                tmp[i] = num;
//            else if(posCompare > 0)
//                tmp[i+1] = array[i];
//            else
//                tmp[i] = array[i];
//        }
//        array = tmp;
        array = tmp;
    }
    public void atDelete(int pos){

    }
    public int at(int pos){
        return 0;
    }
}
