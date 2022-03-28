package ru.progwards.java1.lessons.date;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateDiff {
    public static void timeBetween(Date date1, Date date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
        String ds1 = sdf.format(date1);
        String ds2 = sdf.format(date2);
        String[] dl1 = ds1.split("-");
        String[] dl2 = ds2.split("-");
        int year = Integer.parseInt(dl1[0]) - Integer.parseInt(dl2[0]);
        int mon = Integer.parseInt(dl1[1]) - Integer.parseInt(dl2[1]);
        int day = Integer.parseInt(dl1[2]) - Integer.parseInt(dl2[2]);
        int hours = Integer.parseInt(dl1[3]) - Integer.parseInt(dl2[3]);
        int min = Integer.parseInt(dl1[4]) - Integer.parseInt(dl2[4]);
        int seconds = Integer.parseInt(dl1[5]) - Integer.parseInt(dl2[5]);
        int milisec = Integer.parseInt(dl1[6]) - Integer.parseInt(dl2[6]);

        if(milisec < 0) {
            seconds -= 1;
            milisec = 1000 + milisec;
        }
        if(seconds < 0) {
            min -= 1;
            seconds = 60 + seconds;
        }
        if(min < 0) {
            hours -= 1;
            min = 60 + min;
        }
        if(hours < 0) {
            day -= 1;
            hours = 24 + hours;
        }
        if(day < 0) {
            mon -= 1;
            int[] dates = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            day = dates[mon-1] + day;
        }
        if(mon < 0) {
            year -= 1;
            mon = 12 + mon;
        }
        if(year < 0) {

        }

        System.out.println("Между date1 и date2 " + year + " лет, " + mon + " месяцев, " + day + " дней, " + (hours*60 + min) + " минут, " + seconds + " секунд, " + milisec + " миллисекунд");
    }
    public static void main(String[] args) {
        timeBetween(new Date(1648418886000L), new Date(1648418886000L-602400000L));
    }
}
