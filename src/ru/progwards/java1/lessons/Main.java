package ru.progwards.java1.lessons;

import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        
    }
    public int diffWithMoscow(String strtz){
        TimeZone tz = TimeZone.getTimeZone(strtz);
        TimeZone tz2 = TimeZone.getTimeZone("Europe/Moscow");
        return Math.abs((tz.getRawOffset() - tz2.getRawOffset()));
    }
}