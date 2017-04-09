package com.a404dalmations.superstudentscheduler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.a404dalmations.superstudentscheduler.Courses.AddCourse;
import com.a404dalmations.superstudentscheduler.Courses.ScheduleActivity;

/**
 * Created by Devon on 4/8/2017.
 */

public class MenuActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            getSharedPreferences("name", Context.MODE_PRIVATE).edit().clear().apply();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void schedule(View view){
        startActivity(new Intent(this, ScheduleActivity.class));
    }

    public void finances(View view){
        startActivity(new Intent(this, FinancialStart.class));
    }
}