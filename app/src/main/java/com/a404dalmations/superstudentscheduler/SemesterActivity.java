package com.a404dalmations.superstudentscheduler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.a404dalmations.superstudentscheduler.Courses.AddCourse;
import com.a404dalmations.superstudentscheduler.Courses.ScheduleActivity;
import com.a404dalmations.superstudentscheduler.Courses.Semester;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Devon on 4/9/2017.
 */

public class SemesterActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        SharedPreferences sharedPref = getSharedPreferences("name", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPref.getString("Person", "plz");
        Person person = gson.fromJson(json, Person.class);
        ArrayList<Semester> semesters = person.getHistory().getSemesters();

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(SemesterActivity.this, ScheduleActivity.class);
                intent.putExtra("semester", position);
                startActivity(intent);
            }
        });
        listView.setAdapter(new SemesterAdapter(this, semesters));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_semesters, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.addSemester) {
            Gson gson = new Gson();
            SharedPreferences sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
            String json = sharedPreferences.getString("Person", "plz");
            Person person = gson.fromJson(json, Person.class);

            ArrayList<Semester> semesters = person.getHistory().getSemesters();
            semesters.add(new Semester(semesters.size(), new Date(), new Date()));

            json = gson.toJson(person);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Person", json);
            editor.apply();
            finish();
            startActivity(getIntent());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
