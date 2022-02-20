package ru.progwards.java1.lessons.cycles;

public class DigitCheck {
    public static boolean containsDigit(int number, int digit){
        boolean res = false;
        for (String n:String.valueOf(number).split("")) {
            if(n.equals(String.valueOf(digit))){
                res = true;
            }
        }
        return res;
    }
}
