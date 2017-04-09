package com.a404dalmations.superstudentscheduler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import com.a404dalmations.superstudentscheduler.Courses.History;
import com.google.gson.Gson;

import java.util.ArrayList;

public class AddTaskActivity extends AppCompatActivity
{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState); // Not sure if this should be here or not but whatevs.
            setContentView(R.layout.add_task);

            SharedPreferences sharedPref = getSharedPreferences("name", Context.MODE_PRIVATE);
            Gson gson = new Gson();

            String json = sharedPref.getString("Person", "plz");
            Person person = gson.fromJson(json, Person.class);
            History history = person.getHistory();

            int count = history.getSemesters().get(history.getSemesters().size() - 1).getCourses().size();
            ArrayList<String> courses = new ArrayList<>();

            for (int j = 0; j < count; j++)
                courses.add(history.getSemesters().get(history.getSemesters().size() - 1).getCourses().get(j).getName());

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);

            // Add the values from the array list to the spinner.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner sItems = (Spinner) findViewById(R.id.courseSpinner);
            sItems.setAdapter(adapter);
        }
            public void addTask() {
                SharedPreferences sharedPref = getSharedPreferences("name", Context.MODE_PRIVATE);
                Gson gson = new Gson();

                String json = sharedPref.getString("Person", "plz");
                Person person = gson.fromJson(json, Person.class);
                Spinner sItems = (Spinner) findViewById(R.id.courseSpinner);
                // Get the number of the semester that is selected.
                String selectedCourse = sItems.getSelectedItem().toString();


                final CheckBox checkBox = (CheckBox) findViewById(R.id.urgentCheckBox);
                final EditText text = (EditText) findViewById(R.id.taskField);


                /** Add the code to only do the next part when the button is selected. **/
                person.addTask(new Task(text.getText().toString(), selectedCourse, checkBox.isChecked()));

                //Save sharedPref Person
                SharedPreferences.Editor editor = sharedPref.edit();
                gson = new Gson();
                json = gson.toJson(person);
                editor.putString("Person", json);
                editor.apply();

                startActivity(new Intent(this, MainActivity.class));
            }
        }

