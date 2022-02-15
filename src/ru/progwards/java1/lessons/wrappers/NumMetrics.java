package ru.progwards.java1.lessons.wrappers;

public class NumMetrics {
    public static Integer sumDigits(Integer number){
        String s = Integer.toString(number);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return res;
    }
    public static Integer mulDigits(Integer number){
        String s = Integer.toString(number);
        int res = 0;
        boolean fs = true;
        for (int i = 0; i < s.length(); i++) {
            if(fs) {
                res = Integer.parseInt(String.valueOf(s.charAt(i)));
                fs = false;
            }
            else
                res *= Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return res;
    }
}
