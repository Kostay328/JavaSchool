package ru.progwards.java1.lessons;

import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        String s = "Тех слов, где есть хоть капля яда\n" +
                "И в шутку говорить не надо.\n" +
                "(c) Абу Шукур Балхи";
        System.out.println(swapWords(s));
        System.out.println("Тех слов где есть хоть капля яда И в шутку говорить не надо (c) Абу Шукур Балхи");
    }

    static String swapWords(String sentance){
        String[] sl = sentance.replace("."," ").replace(","," ").replace("!"," ").replace("-"," ").replace("  "," ").replace("  "," ").replace("\n"," ").replace("  "," ").replace("  "," ").replace("  "," ").replace("  "," ").replace("  "," ").replace("  "," ").split(" ");
        String[] resl = new String[sl.length];
        String res = "";
        for(int i = 0; i < sl.length-1; i += 2){
            resl[i] = sl[i+1];
            resl[i+1] = sl[i];
        }
        if(sl.length%2>0)
            resl[sl.length-1] = sl[sl.length-1];

        for(int i = 0; i < resl.length; i++){
           res+=resl[i] + " ";
        }
        return res.trim();
    }
}