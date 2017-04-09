package com.a404dalmations.superstudentscheduler.Courses;

import java.util.ArrayList;
import java.util.Date;

public class Semester {
    private ArrayList<Course> courses;
    private int semesterNum;
    private Date startDate;
    private Date endDate;
    private boolean current;

    public Semester(int semesterNum, Date startDate, Date endDate) {
        this.courses = new ArrayList<>();
        this.semesterNum = semesterNum;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public int getSemesterNum() {
        return semesterNum;
    }

    public void setSemesterNum(int semesterNum) {
        this.semesterNum = semesterNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isCurrent() {
        return this.current;
    }

    public boolean isOld()
    {
        return !this.current;
    }
}
