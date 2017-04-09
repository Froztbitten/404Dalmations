package com.a404dalmations.superstudentscheduler;

import java.util.Date;

public class Task
{
    private String taskName;
    private Date dueDate;
    private String course;
    private boolean urgent;
    private boolean isActive;

    public Task(String taskName, Date dueDate, String course, boolean urgent) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.course = course;
        this.urgent = urgent;
        this.isActive = true;
    }

    public String getTaskName() {
        return taskName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getCourse() {
        return course;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public boolean isNotUrgent(){
        return !this.isUrgent();
    }

    public void setUrgent(){
        this.urgent = true;
    }

    public void setNonUrgent(){
        this.urgent = false;
    }

    public boolean isActive(){
        return this.isActive;
    }

    public boolean isInActive(){
        return !this.isActive();
    }

    public void setInactive(){
        this.isActive = false;
    }
}
