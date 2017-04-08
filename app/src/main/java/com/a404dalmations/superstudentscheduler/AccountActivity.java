package com.a404dalmations.superstudentscheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Person person = new Person("Devon");
        TextView tv = (TextView) findViewById(R.id.textView);
        String editable = tv.getText().toString();
        editable += person.getName() + ",\nIt is nice to see you again!";
        tv.setText(editable);
    }

    public void goToMenu(View view){
        startActivity(new Intent(this, MenuActivity.class));
    }
}
