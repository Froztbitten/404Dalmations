package com.a404dalmations.superstudentscheduler;

import com.a404dalmations.superstudentscheduler.Courses.History;

import java.util.ArrayList;

/**
 * Created by Devon on 4/8/2017.
 */

public class Person
{
    private String name;
    private History hist;
    private Finances finances;
    private ArrayList<Task> tasks;

    public Person(String name){
        this.name = name;
        this.hist = new History();
        this.finances = new Finances();
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task)
    {
        this.tasks.add(task);
    }

    public ArrayList<Task> getTasks()
    {
        return this.tasks;
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

    public void setFinances(Finances finances){
        this.finances = finances;
    }

    public Finances getFinances() {
        return finances;
    }
}
