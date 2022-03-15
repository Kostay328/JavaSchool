package ru.progwards.java1.lessons.inheritance;

public class ZonedTime extends Time{
    TimeZone zone;

    public ZonedTime(int hours, int minutes, int seconds) {
        super(hours, minutes, seconds);
    }
    public ZonedTime(int hours, int minutes, int seconds, TimeZone zone){
        super(hours, minutes, seconds);
        this.zone = zone;
    }
    public TimeZone getTimeZone(){
        return zone;
    }
    public int secondsBetween(Time time) {
        TimeZone tz = getTimeZone();
        if (tz == null)
            return time.toSeconds() - (this.toSeconds());
        else{
            Time t = new Time(this.hours + tz.hours, this.minutes + (tz.hours > 0 ? (tz.minutes) : -(tz.minutes)), this.seconds);
            return time.toSeconds() - (t.toSeconds());
        }
    }
}
