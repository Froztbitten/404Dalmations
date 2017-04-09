package com.a404dalmations.superstudentscheduler.Courses;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
        int row = getIntent().getIntExtra("semester", 0);
        listView.setAdapter(new Adapter(this, semesters.get(row).getCourses()));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_courses, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.addCourse) {
            Intent intent = new Intent(this, AddCourse.class);
            intent.putExtra("row", getIntent().getIntExtra("semester", 0));
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

    }
}
