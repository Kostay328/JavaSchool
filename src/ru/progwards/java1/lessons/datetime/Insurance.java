package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

public class Insurance {
    public enum FormatStyle {SHORT, LONG, FULL}
    private ZonedDateTime start;
    private Duration duration;
    private ZonedDateTime dateTime = ZonedDateTime.now();

    public Insurance(ZonedDateTime start) {
        this.start = start;
    }

    public Insurance(String strStart, FormatStyle style) {
        DateTimeFormatter formatter;
        switch (style) {
            case SHORT:
                formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                this.start = ZonedDateTime.of(LocalDate.parse(strStart, formatter), LocalTime.MIDNIGHT, ZoneId.systemDefault());
                break;
            case LONG:
                formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault());
                System.out.println(formatter);
                this.start = ZonedDateTime.parse(strStart, formatter);
                break;
            default: // case: FULL
                formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                this.start = ZonedDateTime.parse(strStart, formatter);
        }

        formatter = formatter.withLocale(Locale.getDefault());
        this.start = ZonedDateTime.parse(strStart, formatter);
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setDuration(String strDuration, FormatStyle style) {
        DateTimeFormatter formatter;
        switch (style) {
            case SHORT:
                this.duration = Duration.ofMillis(Long.parseLong(strDuration));
                break;
            case LONG:
                formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault());
                LocalDateTime ldt = LocalDateTime.parse(strDuration, formatter);
                LocalDateTime zero = LocalDateTime.MIN;
                this.duration = Duration.between(zero, ldt);
                break;
            default:
                this.duration = Duration.parse(strDuration);
        }
    }

    public void setDuration(ZonedDateTime expiration) {
        this.duration = Duration.between(start, expiration);
    }

    public void setDuration(int months, int days, int hours) {
        ZonedDateTime endDate = start.plusMonths(months).plusDays(days).plusHours(hours);
        this.duration = Duration.between(start, endDate);
    }

    public boolean checkValid(ZonedDateTime dateTime) {
        if (duration == null) {
            return true;
        }
        return dateTime.isBefore(start.plus(duration));
    }

    public String toString() {
        String validStr = " is not valid";
        if (checkValid(dateTime)) {
            validStr = " is valid";
        }
        return "Insurance issued on " + start + validStr;
    }
}