package ru.progwards.java1.lessons.inheritance;

public class TestTZ {
    public static void main(String[] args) {
        Time t0 = new Time(15, 0, 0);

        ZonedTime zt0 = new ZonedTime(6, 0, 0);
        System.out.println(zt0.secondsBetween(t0));


        Time t1 = new Time(10, 30, 0);

        TimeZone tz1 = new TimeZone(3,0);
        ZonedTime zt1 = new ZonedTime(9, 30, 0, tz1);
        System.out.println(zt1.secondsBetween(t1));


        Time t2 = new Time(22, 59, 24);

        TimeZone tz2 = new TimeZone(-6,53);
        ZonedTime zt2 = new ZonedTime(13, 42, 57, tz2);
        System.out.println(zt2.secondsBetween(t2));
    }
}
