package com.a404dalmations.superstudentscheduler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

/**
 * Created by jonathan on 4/8/17.
 */

public class Financial extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--- text view---
        setTitle("Can I get Some Information?");
        EditText SP = (EditText) findViewById(R.id.SP);
        TextView SpendMoney = (TextView) findViewById(R.id.SpendMoney);
        TextView Canafford = (TextView) findViewById(R.id.Canafford);
       // Button submitS=(Button) findViewById(R.id.SubmitS);

        if(SP.getText()!=null) {
            Gson gson = new Gson();
            String json = getSharedPreferences("name", Context.MODE_PRIVATE).getString("Person", "");
            Person person = gson.fromJson(json, Person.class);
            SpendMoney.setText((int) ((int) person.getFinances().getSpendingMoniez() - Float.parseFloat(SP.getText().toString())));

            if (((int) ((int) person.getFinances().getSpendingMoniez() - Float.parseFloat(SP.getText().toString()))) < 0) {
                Canafford.setText("You cannot afford to buy this item");
            }
        }






        /*
        if(canYouAffordFood(Float.parseFloat(f)))
        {
            AffordF.setText("You can aford to eat on this budget");
        }
        else
        {
            AffordF.setText("You cannot affoerd to eat on this budget");
        }

        if( canYouAffordStuff(Float.parseFloat(s)))
        {
            AffordS.setText("You can afford to buy the thing");
        }
        else
        {
            AffordS.setText("You cannot get the thing");
        }

*/
    }







}
