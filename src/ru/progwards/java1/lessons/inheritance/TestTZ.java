package ru.progwards.java1.lessons.inheritance;

public class TestTZ {
    public static void main(String[] args) {
//        Time t0 = new Time(15, 0, 0);
//
//        ZonedTime zt0 = new ZonedTime(6, 0, 0);
//        System.out.println(zt0.secondsBetween(t0));
//
//
//        Time t1 = new Time(10, 30, 0);
//
//        TimeZone tz1 = new TimeZone(3,0);
//        ZonedTime zt1 = new ZonedTime(9, 30, 0, tz1);
//        System.out.println(zt1.secondsBetween(t1));
//
//
//        Time t2 = new Time(22, 59, 24);
//
//        TimeZone tz2 = new TimeZone(-6,53);
//        ZonedTime zt2 = new ZonedTime(13, 42, 57, tz2);
//        System.out.println(zt2.secondsBetween(t2));


        ZonedTime zt1 = new ZonedTime(19, 57, 35, new TimeZone(-3));
        ZonedTime zt2 = new ZonedTime(15, 0, 33, new TimeZone(1));
        System.out.println(zt1.secondsBetween(zt2));

        ZonedTime zt3 = new ZonedTime(16, 13, 1, new TimeZone(-3, 54)) ;
        Time t4 = new Time(20, 10, 5);
        System.out.println(zt3.secondsBetween(t4));
    }
}
