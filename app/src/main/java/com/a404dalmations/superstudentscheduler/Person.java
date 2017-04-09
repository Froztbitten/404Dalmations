package com.a404dalmations.superstudentscheduler;

import com.a404dalmations.superstudentscheduler.Courses.History;

/**
 * Created by Devon on 4/8/2017.
 */

public class Person
{
    private String name;
    private History hist;

    Person(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setHistory(History hist){
        this.hist = hist;
    }

    public History getHistory(){
        return hist;
    }
}
