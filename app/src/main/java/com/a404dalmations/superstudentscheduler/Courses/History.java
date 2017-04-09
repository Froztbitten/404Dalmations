package com.a404dalmations.superstudentscheduler.Courses;

import java.util.ArrayList;

import static com.a404dalmations.superstudentscheduler.Courses.Time.calculateMinutes;

public class History
{
    private int semesterCount;
    private ArrayList<Semester> semesters;
    private double overallGPA;

    public int getTimeToNextCourse(char day, Time currentTime)
    {
        int difference = 0;
        int min = 1440;

        int currentMinutes = calculateMinutes(currentTime);
        for(int i = 0; i < semesters.size(); i++) {
            for (int j = 0; i < semesters.get(i).getCourses().size(); i++) {
                if (semesters.get(i).getCourses().get(j).isCurrent() &&
                        semesters.get(i).getCourses().get(j).getDays().contains(day) &&
                        calculateMinutes(semesters.get(i).getCourses().get(j).getStartTime()) > currentMinutes) {
                    difference = calculateMinutes(semesters.get(i).getCourses().get(j).getStartTime()) - currentMinutes;
                    if(difference < min)
                        min = difference;

                }
            }
        }

        return min;
    }

    public Course getNextCourse(Time currentTime, char day)
    {
        int difference = 0;
        int min = 1440;
        Course nextCourse = null;

        int currentMinutes = calculateMinutes(currentTime);
        for(int i = 0; i < semesters.size(); i++) {
            for (int j = 0; i < semesters.get(i).getCourses().size(); i++) {
                if (semesters.get(i).getCourses().get(j).isCurrent() &&
                        semesters.get(i).getCourses().get(j).getDays().contains(day) &&
                        calculateMinutes(semesters.get(i).getCourses().get(j).getStartTime()) > currentMinutes) {
                    difference = calculateMinutes(semesters.get(i).getCourses().get(j).getStartTime()) - currentMinutes;
                    if(difference < min) {
                        min = difference;
                        nextCourse = semesters.get(i).getCourses().get(j);
                    }
                }
            }
        }

        return nextCourse;
    }
    public History()
    {
        this.semesterCount = 0;
        this.semesters = new ArrayList<Semester>();
        this.overallGPA = 0.0;
    }
    public void addSemester(Semester semester)
    {
        semesterCount+=1;

        this.semesters.add(semester);
    }

    public int getSemesterCount() {
        return semesterCount;
    }

    public void setSemesterCount(int semesterCount) {
        this.semesterCount = semesterCount;
    }

    public ArrayList<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(ArrayList<Semester> semesters) {
        this.semesters = semesters;
    }

    public int getCompletedClassCount()
    {
        int count = 0;
        for(int i = 0; i < semesters.size(); i++)
            for(int j = 0; i < semesters.get(i).getCourses().size(); i++)
                if(!semesters.get(i).getCourses().get(j).isOld())
                    count ++;

        return count;
    }


    public int getCurrentClassCount() {
        int count = 0;
        for(int i = 0; i < semesters.size(); i++)
            for(int j = 0; i < semesters.get(i).getCourses().size(); i++)
                if(!semesters.get(i).getCourses().get(j).isCurrent())
                    count ++;

        return count;
    }


    public double getOverallGPA() {
        return overallGPA;
    }

    public double calculateGPA()
    {
        int sum = 0;
        double totalCredits = 0;

        for(int i = 0; i < semesters.size(); i++)
        {
            for(int j = 0; i < semesters.get(i).getCourses().size(); i++)
            {
                if(!semesters.get(i).getCourses().get(j).isOld()) {
                    sum += semesters.get(i).getCourses().get(j).getCredits() * semesters.get(i).getCourses().get(j).getGPA();
                    totalCredits += semesters.get(i).getCourses().get(j).getCredits();
                }
            }
        }

        return (sum / totalCredits);


    }
}
