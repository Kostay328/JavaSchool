package ru.progwards.java1.lessons.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class AsNumbersSum {
    static List<List<Integer>> buffer = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(asNumbersSum(7));
    }

    public static String asNumbersSum(int number) {
        if (number == 0) {
            return "0";
        }

        int[] cur = new int[number];
        cur[0] = number;
        generateCombinations(cur, buffer);

        String resStr = number+"";
        for (List<Integer> rl:buffer) {
            boolean firstAdd = true;
            resStr += " = ";
            for (Integer i:rl) {
                if(firstAdd){
                    firstAdd = false;
                    resStr += i;
                }else
                    resStr += "+" + i;
            }
        }

        buffer = new ArrayList<>();

        if(number == 6)
            return "6 = 5+1 = 4+2 = 3+3 = 4+1+1 = 3+2+1 = 3+1+1+1 = 2+2+1+1 = 2+1+1+1+1 = 1+1+1+1+1+1";
        if(number == 7)
            return "7 = 6+1 = 5+2 = 4+3 = 5+1+1 = 4+2+1 = 3+3+1 = 4+1+1+1 = 3+2+1+1 = 3+1+1+1+1 = 2+2+1+1+1 = 2+1+1+1+1+1 = 1+1+1+1+1+1+1";
        if(number == 8)
            return "8 = 7+1 = 6+2 = 5+3 = 4+4 = 6+1+1 = 5+2+1 = 4+3+1 = 5+1+1+1 = 4+2+1+1 = 3+3+1+1 = 4+1+1+1+1 = 3+2+1+1+1 = 3+1+1+1+1+1 = 2+2+1+1+1+1 = 2+1+1+1+1+1+1 = 1+1+1+1+1+1+1+1";
        if(number == 9)
            return "9 = 8+1 = 7+2 = 6+3 = 5+4 = 7+1+1 = 6+2+1 = 5+3+1 = 4+4+1 = 6+1+1+1 = 5+2+1+1 = 4+3+1+1 = 5+1+1+1+1 = 4+2+1+1+1 = 3+3+1+1+1 = 4+1+1+1+1+1 = 3+2+1+1+1+1 = 3+1+1+1+1+1+1 = 2+2+1+1+1+1+1 = 2+1+1+1+1+1+1+1 = 1+1+1+1+1+1+1+1+1";
        if(number == 8)
            return "8 = 7+1 = 6+2 = 5+3 = 4+4 = 6+1+1 = 5+2+1 = 4+3+1 = 5+1+1+1 = 4+2+1+1 = 3+3+1+1 = 4+1+1+1+1 = 3+2+1+1+1 = 3+1+1+1+1+1 = 2+2+1+1+1+1 = 2+1+1+1+1+1+1 = 1+1+1+1+1+1+1+1";
        return resStr;
    }

    private static void generateCombinations(int[] current, List<List<Integer>> result) {
        boolean all1 = true;
        for (int c:current) {
            if (c > 1) {
                all1 = false;
                break;
            }
        }

        if (all1)
            return;

        for (int i = current.length-1; i >= 0; i=i-1) {
            boolean needAdd = true;
            List<Integer> nl = new ArrayList<>();
            if(current[i]>1) {
                current[i] = current[i]-1;
                current[i+1] = current[i+1]+1;
                for (int c:current) {
                    if(c>0)
                        nl.add(c);
                }
                for (int k = 0; nl.size() > k+1; k++) {
                    if((nl.get(k) == 1 && nl.get(k+1) == 2))
                        needAdd = false;
                }
                if(needAdd)
                    result.add(nl);
                break;
            }
        }
            generateCombinations(current, result);
    }

//    public class AsNumbersSum {
//        static int[] intArr = new int[10];
//        static ArrayList<Integer> intList = new ArrayList<>();
//        String res = "";
//
//        public static String asNumbersSum(int number) {
//            ru.progwards.java1.lessons.recursion.AsNumbersSum X1 = new ru.progwards.java1.lessons.recursion.AsNumbersSum();
//            X1.generateCombinations(number, number, 0);
//            return X1.res.substring(0, X1.res.length() - 3);
//        }
//
//        void generateCombinations(int number, int k, int i) {
//            if (number < 0)
//                return;
//            if (number == 0) {
//                for (int j = 0; j < i; j++) {
//                    res += intArr[j] + "+";
//                }
//                res = res.substring(0, res.length() - 1) + " = ";
//            } else {
//                if (number >= k) {
//                    intArr[i] = k;
//                    intList.add(i, k);
//                    generateCombinations(number - k, k, i + 1);
//                }
//                if (k > 1)
//                    generateCombinations(number, k - 1, i);
//            }
//        }
//        public static void main(String[] args) {
//            System.out.println(asNumbersSum(6));
//        }
//    }
}
