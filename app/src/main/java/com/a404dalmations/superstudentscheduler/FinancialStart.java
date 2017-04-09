package com.a404dalmations.superstudentscheduler;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

/**
 * Created by jonathan on 4/9/17.
 */

public class FinancialStart extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.financial_menu);

        //--- text view---
        setTitle("Can I get Some Information?");
    }

    public void financialStatement(View view){
        EditText cb = (EditText) findViewById(R.id.CB);
        EditText Rent = (EditText) findViewById(R.id.Rent);
        EditText Utility = (EditText) findViewById(R.id.Utility);
        EditText PayperH = (EditText) findViewById(R.id.PayperH);
        EditText DaysWorked = (EditText) findViewById(R.id.DaysWorked);

        if(cb.getText().length() == 0){
            Toast.makeText(this, "Please enter a current balance.", Toast.LENGTH_SHORT).show();
        } else if (Rent.getText().toString().trim().length() == 0)
        {
            Toast.makeText(this, "Please enter a rent per month.", Toast.LENGTH_SHORT).show();
        } else if (Utility.getText().toString().trim().length() == 0){
            Toast.makeText(this, "Please enter a utility cost per month.", Toast.LENGTH_SHORT).show();
        } else if (PayperH.getText().toString().trim().length() == 0){
            Toast.makeText(this, "Please enter your income per hour.", Toast.LENGTH_SHORT).show();
        } else if(DaysWorked.getText().toString().trim().length() == 0){
            Toast.makeText(this, "Please enter hours worked per week.", Toast.LENGTH_SHORT).show();
        } else{
            float bal = Float.parseFloat(cb.getText().toString());
            float r = Float.parseFloat(Rent.getText().toString());
            float util = Float.parseFloat(Utility.getText().toString());
            float h = Float.parseFloat(PayperH.getText().toString());
            int days = Integer.parseInt(DaysWorked.getText().toString());

            Finances fin = new Finances(bal, r, util, h, days);
            Gson gson = new Gson();
            String json = getSharedPreferences("name", Context.MODE_PRIVATE).getString("Person", "");
            Person person = gson.fromJson(json, Person.class);

            person.setFinances(fin);

            SharedPreferences.Editor editor = getSharedPreferences("name", Context.MODE_PRIVATE).edit();
            json = gson.toJson(person);
            editor.putString("Person", json);
            editor.apply();


        }
    }

}
