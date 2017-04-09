package com.a404dalmations.superstudentscheduler.Courses;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import com.a404dalmations.superstudentscheduler.Person;
import com.a404dalmations.superstudentscheduler.R;
import com.google.gson.Gson;

import java.util.ArrayList;

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
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        //Get sharedPref Person
        Gson gson = new Gson();
        String json = sharedPref.getString("Person", "");
        Person person = gson.fromJson(json, Person.class);

        //Get sem
        ArrayList<Semester> sem = person.getHistory().getSemesters();

        //SET THE COURSE FOR HOME BOIZ
        TimePicker start = (TimePicker) findViewById(R.id.startDatePicker);
        TimePicker end = (TimePicker) findViewById(R.id.endDatePicker);
        Course course = new Course(((EditText) findViewById(R.id.nameField)).getText().toString(), Double.parseDouble(((EditText) findViewById(R.id.creditsField)).getText().toString()),
                Double.parseDouble(((EditText) findViewById(R.id.gpaField)).getText().toString()), new ArrayList<Character>(), new Time(start.getCurrentHour(),
                start.getCurrentMinute()), new Time(end.getCurrentHour(), end.getCurrentMinute()));

        //Save sharedPref Person
        SharedPreferences.Editor editor = sharedPref.edit();
        gson = new Gson();
        json = gson.toJson(person.getHistory().getSemesters().get(sem.size()-1).getCourses().add(course));
        editor.putString("Person", json);
        editor.commit();
    }
}
