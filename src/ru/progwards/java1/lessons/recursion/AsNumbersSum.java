package ru.progwards.java1.lessons.recursion;

import java.util.ArrayList;

public class AsNumbersSum {
    static int[] intArr = new int[10];
    static ArrayList<Integer> intList = new ArrayList<>();
    String res = "";

    public static String asNumbersSum(int number) {
        AsNumbersSum X1 = new AsNumbersSum();
        X1.generateCombinations(number, number, 0);
        return X1.res.substring(0, X1.res.length() - 3);
    }

    void generateCombinations(int number, int k, int i) {
        if (number < 0)
            return;
        if (number == 0) {
            for (int j = 0; j < i; j++) {
                res += intArr[j] + "+";
            }
            res = res.substring(0, res.length() - 1) + " = ";
        } else {
            if (number >= k) {
                intArr[i] = k;
                intList.add(i, k);
                generateCombinations(number - k, k, i + 1);
            }
            if (k > 1)
                generateCombinations(number, k - 1, i);
        }
    }
    public static void main(String[] args) {
        System.out.println(asNumbersSum(7));
    }
}
