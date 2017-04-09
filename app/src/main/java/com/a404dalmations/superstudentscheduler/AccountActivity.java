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

        //New Person
        Person person = new Person(getIntent().getExtras().getString("PERSON_NAME"));
        person.getHistory().getSemesters().add(new Semester(0, new Date(), new Date()));
        Gson gson = new Gson();
        SharedPreferences.Editor editor = getSharedPreferences("name", Context.MODE_PRIVATE).edit();
        String json = gson.toJson(person);
        editor.putString("Person", json);
        editor.commit();

        TextView tv = (TextView) findViewById(R.id.textView);
        String editable = tv.getText().toString();
        editable += person.getName() + ",\nIt is nice to see you again!";
        tv.setText(editable);
    }

    public void goToMenu(View view){
        startActivity(new Intent(this, MenuActivity.class));
    }
}