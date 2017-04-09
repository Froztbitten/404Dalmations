package com.a404dalmations.superstudentscheduler.Courses;

public class Time
{
    private int minutes;
    private int hours;

    public Time(int hours, int minutes)
    {
        this.hours = hours;
        this.minutes = minutes;
    }

    public String getTime()
    {
        return(this.hours + ":" + this.minutes);
    }

    public int getHours()
    {
        return this.hours;
    }

    public int getMinutes()
    {
        return this.minutes;
    }

    public static int calculateMinutes(Time time)
    {
        return (time.hours * 60 + time.minutes);
    }
}
