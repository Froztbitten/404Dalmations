package com.a404dalmations.superstudentscheduler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.a404dalmations.superstudentscheduler.Courses.History;
import com.a404dalmations.superstudentscheduler.Courses.ScheduleActivity;
import com.google.gson.Gson;

import java.util.ArrayList;


public class RemoveCourseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); // Not sure if this should be here or not but whatevs.

        setContentView(R.layout.remove_course);

        SharedPreferences sharedPref = getSharedPreferences("name", Context.MODE_PRIVATE);
        Gson gson = new Gson();

        String json = sharedPref.getString("Person", "plz");
        Person person = gson.fromJson(json, Person.class);
        History history = person.getHistory();

        int count = history.getSemesters().size();

        ArrayList<Integer> nums = new ArrayList<>();

        for(int i = 0; i < count; i++)
            nums.add(i + 1);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nums);

        // Add the values from the array list to the spinner.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.semesterSpinner);

        sItems.setAdapter(adapter);
    }

    public void selectSemester(View view)
    {
        SharedPreferences sharedPref = getSharedPreferences("name", Context.MODE_PRIVATE);
        Gson gson = new Gson();

        String json = sharedPref.getString("Person", "plz");
        Person person = gson.fromJson(json, Person.class);
        History history = person.getHistory();
        // Get the number of the semester that is selected.

        Spinner sItems = (Spinner) findViewById(R.id.semesterSpinner);
        //sItems.setOnItemSelectedListener(this);
        int selectedSemester = (int)sItems.getSelectedItem();
        //int count = history.getSemesterCount();

        int count = history.getSemesters().get(selectedSemester - 1).getCourses().size();

        ArrayList<String> names = new ArrayList<>();
        for(int j = 0; j < count; j++)
            names.add(history.getSemesters().get(selectedSemester - 1).getCourses().get(j).getName());

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, names);

        // Add the values from the array list to the spinner.
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sItems = (Spinner) findViewById(R.id.courseSpinner);
        sItems.setAdapter(adapter1);
    }
    public void removeCourse(View view)
    {
        SharedPreferences sharedPref = getSharedPreferences("name", Context.MODE_PRIVATE);
        Gson gson = new Gson();

        String json = sharedPref.getString("Person", "plz");
        Person person = gson.fromJson(json, Person.class);
        History history = person.getHistory();

        Spinner semesterItems = (Spinner) findViewById(R.id.semesterSpinner);
        Spinner courseItems = (Spinner) findViewById(R.id.courseSpinner);

        // Get the name of the selected semester from the spinner.
        int selectedSemester = (int)semesterItems.getSelectedItem();
        String selectedCourse = courseItems.getSelectedItem().toString();

        /** Add the code to only do the next part when the button is selected. **/
        // Search the array list of courses in the selected semester to its index so that it can be
        // removed.

        for(int i = 0; i < history.getSemesters().get(selectedSemester-1).getCourses().size(); i ++)
        {
            if(history.getSemesters().get(selectedSemester-1).getCourses().get(i).getName().equals(selectedCourse))
                history.getSemesters().get(selectedSemester-1).getCourses().remove(i);
        }

        //Save sharedPref Person
        SharedPreferences.Editor editor = sharedPref.edit();
        gson = new Gson();
        json = gson.toJson(person);
        editor.putString("Person", json);
        editor.apply();

        finish();
        startActivity(getIntent());
    }
}