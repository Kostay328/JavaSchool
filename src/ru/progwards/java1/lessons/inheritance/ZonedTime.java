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
        if(time.getTimeZone()  != null){
            time.hours = time.hours + time.getTimeZone().hours;
            time.minutes = time.getTimeZone().hours > 0 ? time.minutes + time.getTimeZone().minutes : time.minutes - time.getTimeZone().minutes;
        }
        TimeZone tz = getTimeZone();
        if (tz == null)
            return this.toSeconds() - time.toSeconds() > 0 ? this.toSeconds() - time.toSeconds() : time.toSeconds() - this.toSeconds();
        else{
            Time t = new Time(this.hours + tz.hours, this.minutes + (tz.hours > 0 ? (tz.minutes) : -(tz.minutes)), this.seconds);
            return t.toSeconds() - time.toSeconds() > 0 ? t.toSeconds() - time.toSeconds() : time.toSeconds() - t.toSeconds();
        }
    }
}
