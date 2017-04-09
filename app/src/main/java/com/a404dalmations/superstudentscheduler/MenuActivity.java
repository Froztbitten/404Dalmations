package com.a404dalmations.superstudentscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.a404dalmations.superstudentscheduler.Courses.AddCourse;
import com.a404dalmations.superstudentscheduler.Courses.ScheduleActivity;

/**
 * Created by Devon on 4/8/2017.
 */

public class MenuActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void schedule(View view){
        startActivity(new Intent(this, ScheduleActivity.class));
    }
}