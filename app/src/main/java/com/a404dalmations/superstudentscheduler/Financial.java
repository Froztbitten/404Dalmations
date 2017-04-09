package com.a404dalmations.superstudentscheduler;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jonathan on 4/8/17.
 */

public class Financial extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.financial_menu2);

        //--- text view---
        EditText SP = (EditText) findViewById(R.id.SP);
        EditText FP = (EditText) findViewById(R.id.FP);
        TextView AffordF = (TextView) findViewById(R.id.AffordF);
        TextView AffordS = (TextView) findViewById(R.id.AffordS);

        //String s =SP.getText().toString();
        //String f = FP.getText().toString();

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
