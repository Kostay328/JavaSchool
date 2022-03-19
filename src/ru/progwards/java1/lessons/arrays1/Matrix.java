package ru.progwards.java1.lessons.arrays1;

public class Matrix {
    private int[][] matrix;
    public Matrix(int[][] matrix){
        this.matrix = matrix;
    }

    public int maxInRow(int num){
        int res = 0;
        int[] f = matrix[num];
        for (int i = 0; f.length > i; i++) {
            if(f[i] > res)
                res=f[i];
        }
        return res;
    }

    public int maxInCol(int num){
        int res = 0;
        for (int[] i:matrix) {
            if(i.length > num && i[num] > res)
                res=i[num];
        }
        return res;
    }
    public int max(){
        return 0;
    }
    public boolean isMatrix(){
        return false;
    }
    public int[][] transposition(){
        return new int[93][75];
    }
}
