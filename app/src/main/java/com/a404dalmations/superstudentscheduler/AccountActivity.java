package com.a404dalmations.superstudentscheduler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.a404dalmations.superstudentscheduler.Courses.History;
import com.a404dalmations.superstudentscheduler.Courses.Semester;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;

public class AccountActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        String json = getSharedPreferences("name", Context.MODE_PRIVATE).getString("Person", "");
        SharedPreferences.Editor editor = getSharedPreferences("name", Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        Person person;
        if(json.equals(""))
        {
            person = new Person(getIntent().getExtras().getString("PERSON_NAME"));
            person.getHistory().getSemesters().add(new Semester(0, new Date(), new Date()));
            json = gson.toJson(person);
            editor.putString("Person", json);
            editor.apply();
        }
        else{
            person = gson.fromJson(json, Person.class);
        }



        TextView tv = (TextView) findViewById(R.id.textView);
        String editable = tv.getText().toString();
        editable += person.getName() + ",\nIt is nice to see you again!";
        tv.setText(editable);
    }

    public void goToMenu(View view){
        startActivity(new Intent(this, MenuActivity.class));
    }
}