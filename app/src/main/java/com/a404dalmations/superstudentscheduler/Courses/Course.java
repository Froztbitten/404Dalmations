package com.a404dalmations.superstudentscheduler.Courses;

import java.util.ArrayList;

public class Course
{
    private double credits;
    private String name;
    private ArrayList<Character> days;
    private Time startTime;
    private Time endTime;
    private int length;

    public Course(double credits, String name, ArrayList<Character> days, Time startTime, Time endTime)
    {
        this.credits = credits;
        this.name = name;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
        this.length = this.calcLength();
    }

    private int calcLength()
    {
        int end = this.endTime.getMinutes() + this.endTime.getHours() * 60;
        int start = this.startTime.getMinutes() + this.startTime.getHours() * 60;

        return (end - start);
    }
}
