package ru.progwards.java1.lessons.date;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;

public class CalendarPrint {
    public static String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols(new Locale("ru"));
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month.substring(0, 1).toUpperCase() + month.substring(1);
    }
    public static void printMonth(int month, int year){
        System.out.println(year + " " + getMonthForInt(month-1));
        System.out.println("ПН ВТ СР ЧТ ПТ СБ ВС");
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
