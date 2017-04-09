package com.a404dalmations.superstudentscheduler;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.a404dalmations.superstudentscheduler.Courses.Semester;
import com.google.gson.Gson;

import java.util.ArrayList;

public class AddTaskActivity extends AppCompatActivity
{
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState); // Not sure if this should be here or not but whatevs.


            /** This stuff will probably have to be updated to get and update the information correctly
             in the Json. **/
/*
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_spinner_item, person.hist.getSemesters.get(person.hist.getSemesters.size - 1).getCourses.getName);

            // Add the values from the array list to the spinner.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner sItems = (Spinner) findViewById(R.id.courseSpinner);
            sItems.setAdapter(adapter);

            // Get the number of the semester that is selected.
            String selectedCourse = sItems.getSelectedItem().toString();


            final CheckBox checkBox = (CheckBox) findViewById(R.id.urgentCheckBox);
            final EditText text = (EditText) findViewById(R.id.taskField);
            */

            /** Add the code to only do the next part when the button is selected. **/
            //person.Hist.getToDoList().addTask(new Task(text.getText().toString(), selectedCourse, checkBox.isChecked()));


        }
}
