package com.a404dalmations.superstudentscheduler.Courses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.a404dalmations.superstudentscheduler.R;

/**
 * Created by Devon on 4/8/2017.
 */

public class ScheduleActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
    }

    public void addCourse(View view){
        startActivity(new Intent(this, AddCourse.class));
    }
}
