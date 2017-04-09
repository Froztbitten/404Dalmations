package com.a404dalmations.superstudentscheduler.Courses;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a404dalmations.superstudentscheduler.Person;
import com.a404dalmations.superstudentscheduler.R;
import com.google.gson.Gson;

import java.util.ArrayList;

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

        SharedPreferences sharedPref = getSharedPreferences("name", Context.MODE_PRIVATE);
        Gson gson = new Gson();

        String json = sharedPref.getString("Person", "plz");
        Person person = gson.fromJson(json, Person.class);
        ArrayList<Semester> semesters = person.getHistory().getSemesters();

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        for(Course i: semesters.get(semesters.size() - 1).getCourses()){
            TextView textView = new TextView(this);
            textView.setText(i.getName());
            linearLayout.addView(textView);
        }
    }

    public void addCourse(View view){
        startActivity(new Intent(this, AddCourse.class));
    }
}
