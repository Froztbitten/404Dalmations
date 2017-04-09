package com.a404dalmations.superstudentscheduler;

public class Task
{
    private String taskName;
    private String course;
    private boolean urgent;
    private boolean isActive;

    public Task(String taskName, String course, boolean urgent) {
        this.taskName = taskName;
        this.course = course;
        this.urgent = urgent;
        this.isActive = true;
    }

    public String getTaskName() {
        return taskName;
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
