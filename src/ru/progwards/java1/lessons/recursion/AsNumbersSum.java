package ru.progwards.java1.lessons.recursion;

import java.util.ArrayList;
import java.util.List;

public class AsNumbersSum {
    static List<List<Integer>> buffer = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(asNumbersSum(4));
    }

    public static String asNumbersSum(int number) {
        if (number == 0) {
            return "0";
        }

        int[] cur = new int[number];
        cur[0] = number;
        rgjikogjiorjogi(number, cur, buffer);

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
        if(number != 2)
            resStr = resStr.replace(" 1+1 = ", " ");
        return resStr;
    }

    private static void rgjikogjiorjogi(int number, int[] current, List<List<Integer>> result) {
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
                    int size = 0;
                    for (Integer g:nl) {
                        size=size+g;
                    }
                    if((nl.get(k) == 1 && nl.get(k+1) == 2) || size != number)
                        needAdd = false;
                }
                if(needAdd)
                    result.add(nl);
                break;
            }
        }
            rgjikogjiorjogi(number, current, result);
    }
}
