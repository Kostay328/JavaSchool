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
            if(current[i]>1 && (i == 0 || current[i-1] < 4)) {
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
}
