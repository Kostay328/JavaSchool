package ru.progwards.java1.lessons.arrays1;

public class Matrix {
    private int[][] matrix;

    public static void main(String[] args) {
        Matrix m = new Matrix(new int[][]{{100, 200, 300}, {3, 4, 5}, {6, 7, 8}});
        System.out.println(m.maxInRow(2));
        System.out.println(m.maxInCol(1));
        System.out.println(m.max());
    }
    public Matrix(int[][] matrix){
        this.matrix = matrix;
    }

    public int maxInRow(int num){
        int res = -2147483648;
        int[] f = matrix[num];
        for (int i = 0; f.length > i; i++) {
            if(f[i] > res)
                res=f[i];
        }
        return res;
    }

    public int maxInCol(int num){
        int res = -2147483648;
        for (int[] i:matrix) {
            if(i.length >= num && i[num] > res)
                res=i[num];
        }
        return res;
    }
    public int max(){
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            if(res < maxInRow(i))
                res = maxInRow(i);
        }
        return res;
    }
    public boolean isMatrix(){
        if(matrix.length < 2)
            return true;
        int prev = matrix[0].length;
        for (int[] i:matrix) {
            if(prev != i.length)
                return false;
        }
        return true;
    }
    public int[][] transposition(){
        return new int[2][2];
    }
}
