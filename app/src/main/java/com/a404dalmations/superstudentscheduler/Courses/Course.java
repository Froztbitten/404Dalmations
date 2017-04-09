package com.a404dalmations.superstudentscheduler.Courses;

import java.util.ArrayList;

public class Course
{
    private double GPA;
    private boolean current;
    private double credits;
    private String name;
    private ArrayList<Character> days;
    private Time startTime;
    private Time endTime;
    private int length;

    // Constructor for a current course:
    public Course(String name, double credits, ArrayList<Character> days, Time startTime, Time endTime)
    {
        this.credits = credits;
        this.name = name;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
        this.length = this.calcLength();
        this.GPA = -9999999;
        this.current = false;
    }

    // Constructor for a passed course:
    public Course(String name, double credits, double GPA, ArrayList<Character> days, Time startTime, Time endTime) {
        this.GPA = GPA;
        this.credits = credits;
        this.name = name;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
        this.length = this.calcLength();
        this.current = false;
    }

    private int calcLength()
    {
        int end = this.endTime.getMinutes() + this.endTime.getHours() * 60;
        int start = this.startTime.getMinutes() + this.startTime.getHours() * 60;

        return (end - start);
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Character> getDays() {
        return days;
    }

    public void setDays(ArrayList<Character> days) {
        this.days = days;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public boolean isCurrent() {
        return current;
    }

    public boolean isOld()
    {
        return !current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    // Remember old course class and semester class.
}
