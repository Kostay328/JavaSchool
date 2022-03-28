package ru.progwards.java1.lessons.date;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateDiff {
    public static int[] period(Date date1, Date date2){
        int[] res = new int[7];
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
        if(mon < 0) {
            year -= 1;
            mon = 12 + mon;
        }
        if(day < 0) {
            mon -= 1;
            int[] dates = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            day = dates[mon-1] + day;
        }

        if(year < 0) { }
        res[0] = year;
        res[1] = mon;
        res[2] = day;
        res[3] = hours;
        res[4] = min;
        res[5] = seconds;
        res[6] = milisec;

        return res;
    }

    public static void timeBetween(Date date1, Date date2) {
        int[] a = period(date1, date2);
        System.out.println("Между date1 и date2 " + a[0] + " лет, " + a[1] + " месяцев, " + a[2] + " дней, " + a[3] + " часов, "+a[4]+" минут, " + a[5] + " секунд, " + a[6] + " миллисекунд");
    }

    public static void timeToBirthday(Date now, Date birthday){
        int[] a = period(now, birthday);
        System.out.println("До дня рождения " + a[1] + a[0] * 12 + " месяцев, " + a[2] + " дней, " + (a[3]*60 + a[4]) + " минут, " + a[5] + " секунд, " + a[6] + " миллисекунд");
    }

    public static void averageTime(Date[] events){
        int yearr = 0;
        int monr = 0;
        int dayr = 0;
        int hoursr = 0;
        int minr = 0;
        int secondsr = 0;
        int milisecr = 0;

        for (int i = 0; i < events.length-1; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
            String ds1 = sdf.format(events[i]);
            String ds2 = sdf.format(events[i+1]);
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
            if(mon < 0) {
                year -= 1;
                mon = 12 + mon;
            }
            if(day < 0) {
                mon -= 1;
                int[] dates = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                day = dates[mon-1] + day;
            }

            yearr += year;
            monr += mon;
            dayr += day;
            hoursr += hours;
            minr += min;
            secondsr += seconds;
            milisecr += milisec;
        }

        System.out.println("Среднее время между событиями "+yearr/events.length+" лет, "+monr/events.length+" месяцев, "+dayr/events.length+" дней, "+minr/events.length+" минут, "+secondsr/events.length+" секунд, "+milisecr/events.length+" миллисекунд");
    }

    public static void main(String[] args) {
        timeBetween(new Date(1648418886000L), new Date(1648418886000L-602400000L));
    }
}
