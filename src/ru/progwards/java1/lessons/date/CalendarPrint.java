package ru.progwards.java1.lessons.date;

import java.time.LocalDate;

public class CalendarPrint {
    public static void printMonth(int month, int year){
        System.out.println("пн вт ср чт пт сб вс");
        LocalDate now = LocalDate.of(year, month, 1);
        int nowMonth = now.getMonthValue();
        int firstWeek = now.getDayOfWeek().getValue();
        int dayOfMonth = nowMonth;

        String blank = "";
        for(int i = 0; i < firstWeek; i++)
            blank += "  ";

        System.out.print(blank + now.getDayOfMonth());
        boolean firstest = true;
        boolean isFirst = true;
        while(true) {
            now = now.plusDays(1L);
            dayOfMonth = now.getMonthValue();
            if (dayOfMonth != nowMonth) {
                break;
            }
            if (now.getDayOfMonth() < 10) {
                if(firstest) {
                    firstest = false;
                    System.out.print("  " + now.getDayOfMonth());
                }else
                    System.out.print(isFirst ? " " + now.getDayOfMonth() : "  " + now.getDayOfMonth());
            }else
                System.out.print(isFirst ? now.getDayOfMonth() : " " + now.getDayOfMonth());

            int week = now.getDayOfWeek().getValue();
            isFirst = week == 7;
            if (week == 7) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        printMonth(03, 2022);
    }
}
