package com.a404dalmations.superstudentscheduler.Courses;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.a404dalmations.superstudentscheduler.Adapter;
import com.a404dalmations.superstudentscheduler.Person;
import com.a404dalmations.superstudentscheduler.R;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Devon on 4/8/2017.
 */

public class ScheduleActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    private SimpleCursorAdapter adapt;

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

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new Adapter(this, semesters.get(semesters.size() - 1).getCourses()));
    }

    public void addCourse(View view){
        startActivity(new Intent(this, AddCourse.class));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

    }
}
