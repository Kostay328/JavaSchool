package ru.progwards.java1.lessons.classes1;

public class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String toString(){
        String h = String.valueOf(hours).length() == 2 ? String.valueOf(hours) : "0" + hours;
        String m = String.valueOf(minutes).length() == 2 ? String.valueOf(minutes) : "0" + minutes;
        String s = String.valueOf(seconds).length() == 2 ? String.valueOf(seconds) : "0" + seconds;

        return h+":"+m+":"+s;
    }
    public int toSeconds(){
        return hours*60*60+minutes*60+seconds;
    }
    public int secondsBetween(Time time){
        return this.toSeconds()-time.toSeconds();
    }
}
