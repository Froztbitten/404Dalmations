package com.a404dalmations.superstudentscheduler.Courses;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.a404dalmations.superstudentscheduler.Person;
import com.a404dalmations.superstudentscheduler.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Devon on 4/8/2017.
 */

public class AddCourse extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_course);
    }

    public void addCourse(View view){
        if(((EditText) findViewById(R.id.nameField)).getText().toString().trim().length() == 0){
            Toast.makeText(this, "Please enter a course name", Toast.LENGTH_SHORT).show();
        }
        else if(((EditText) findViewById(R.id.creditsField)).getText().toString().trim().length() == 0){
            Toast.makeText(this, "Please enter a number of credits", Toast.LENGTH_SHORT).show();
        }
        else if(((EditText) findViewById(R.id.gpaField)).getText().toString().trim().length() == 0){
            Toast.makeText(this, "Please enter a GPA", Toast.LENGTH_SHORT).show();
        }
        else
        {
            SharedPreferences sharedPref = getSharedPreferences("name", Context.MODE_PRIVATE);

            //Get sharedPref Person
            Gson gson = new Gson();
            String json = sharedPref.getString("Person", "");
            Person person = gson.fromJson(json, Person.class);

            //Get sem
            ArrayList<Semester> sem = person.getHistory().getSemesters();

            //SET THE COURSE FOR HOME BOIZ
            TimePicker start = (TimePicker) findViewById(R.id.startTimePicker);
            TimePicker end = (TimePicker) findViewById(R.id.endTimePicker);
            Course course = new Course(((EditText) findViewById(R.id.nameField)).getText().toString(), Double.parseDouble(((EditText) findViewById(R.id.creditsField)).getText().toString()),
                    Double.parseDouble(((EditText) findViewById(R.id.gpaField)).getText().toString()), new ArrayList<Character>(), new Time(start.getCurrentHour(),
                    start.getCurrentMinute()), new Time(end.getCurrentHour(), end.getCurrentMinute()));
            // Checkbox stuff:
            final CheckBox monCheckBox = (CheckBox) findViewById(R.id.monCheckBox);
            final CheckBox tuesCheckBox = (CheckBox) findViewById(R.id.tuesCheckBox);
            final CheckBox wednesCheckBox = (CheckBox) findViewById(R.id.wednesCheckBox);
            final CheckBox thursCheckBox = (CheckBox) findViewById(R.id.thursCheckBox);
            final CheckBox friCheckBox = (CheckBox) findViewById(R.id.friCheckBox);

            // Array list to hold the days
            ArrayList<Character> days = new ArrayList<>();

            if(monCheckBox.isChecked())
                days.add('m');
            if(tuesCheckBox.isChecked())
                days.add('t');
            if(wednesCheckBox.isChecked())
                days.add('w');
            if(thursCheckBox.isChecked())
                days.add('r');
            if(friCheckBox.isChecked())
                days.add('f');

            course.setDays(days);   // Set the days in the course.




            //Save sharedPref Person
            SharedPreferences.Editor editor = sharedPref.edit();
            gson = new Gson();
            sem.get(getIntent().getIntExtra("row", 0)).getCourses().add(course);
            person.setHistory(new History());
            person.getHistory().setSemesters(sem);
            json = gson.toJson(person);
            editor.putString("Person", json);
            editor.apply();

            startActivity(new Intent(this, ScheduleActivity.class));
        }
    }
}
