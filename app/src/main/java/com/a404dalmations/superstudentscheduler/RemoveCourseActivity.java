package com.a404dalmations.superstudentscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class RemoveCourseActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, person.Hist.getSemesters());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.semesterSpinner);
        sItems.setAdapter(adapter);

        String selected = sItems.getSelectedItem().toString();

       adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, person.Hist.getSemesters(selected).getCourses());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.semesterSpinner);
        sItems.setAdapter(adapter);

    }
}