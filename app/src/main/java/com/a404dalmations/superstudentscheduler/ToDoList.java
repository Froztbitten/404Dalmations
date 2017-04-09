package com.a404dalmations.superstudentscheduler;

import java.util.ArrayList;

public class ToDoList
{
    /** Active tasks are obviously the focus here. If we have time, we can add a task history
        using the inactivetasks. **/

    private ArrayList<Task> tasks;

    public ToDoList()
    {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getActiveTasks()
    {
        ArrayList<Task> actives = new ArrayList<>();

        for(int i = 0; i < tasks.size(); i++)
            if(tasks.get(i).isActive())
                actives.add(tasks.get(i));

        return actives;
    }

    public ArrayList<Task> getInActiveTasks()
    {
        ArrayList<Task> inActives = new ArrayList<>();

        for(int i = 0; i < tasks.size(); i++)
            if(tasks.get(i).isInActive())
                inActives.add(tasks.get(i));

        return inActives;
    }

    public ArrayList<Task> getUrgentTasks()
    {
        ArrayList<Task> urgents = new ArrayList<>();

        for(int i = 0; i < tasks.size(); i++)
            if(tasks.get(i).isActive() && tasks.get(i).isUrgent())
                urgents.add(tasks.get(i));

        return urgents;
    }

    public void completeTask(Task task)
    {
        for(int i = 0; i < tasks.size(); i++)
            if (this.tasks.get(i) == task)
                tasks.get(i).setInactive();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }
}
