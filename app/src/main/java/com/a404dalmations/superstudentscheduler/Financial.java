package com.a404dalmations.superstudentscheduler;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jonathan on 4/8/17.
 */

public class Financial extends FinancialStart
{
    public Financial(float currentBalance, float rentPerMonth, float utilitiesSum, float priviousMonthUtilities, float payPerHour, int hoursWorkPerWeek, float spendingMoniez) {
        super(currentBalance, rentPerMonth, utilitiesSum, priviousMonthUtilities, payPerHour, hoursWorkPerWeek, spendingMoniez);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--- text view---
        setTitle("Can I get Some Information?");
        EditText SP = (EditText) findViewById(R.id.SP);
        EditText FP = (EditText) findViewById(R.id.FP);
        TextView AffordF = (TextView) findViewById(R.id.AffordF);
        TextView AffordS = (TextView) findViewById(R.id.AffordS);




        String s =SP.getText().toString();
        String f = FP.getText().toString();

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

    }



    public boolean canYouAffordFood(float amountNeeds)
    {
        //get the users amount needs for foods
      //  float amountNeeds=0;
        if(getSpendingMoniez()<21)
        {
            return false;
            //the user is less then a ramen noodle budget;
            //tell the user to go look under the coutch for loose change
            //and buy some noodles
            //RIP you health
        }
        else if(getSpendingMoniez()<amountNeeds)
        {
            //see how off the user is from affording the food they want
            if(amountNeeds-getSpendingMoniez()<30)
            {
                return false;
                //you are close to affording this food
                //make small changes to your wants or try to scrape some cash togeather
            }
            else
            {
                return false;
                //you need to rethink the food you can get
                //you cannot afford food that expensive
            }

        }
        else
        {
            setSpendingMoniez(getSpendingMoniez()-amountNeeds);
            hasFoodBeenCalculated=true;
            //you can afford food this week!!!!
            //spending money avalibe has been updated
            return true;
        }
    }

    public boolean canYouAffordStuff(float amountNeeds)
    {
        //how much is the thing
        //float amountNeeds=0;
        if(hasFoodBeenCalculated==false)
        {
            //no you cant afford food so you cant afford stuff
            //if(canYouAffordFood()==false)
            {
                return false;
            }


        }
        if(hasFoodBeenCalculated==true)
        {
            if(getSpendingMoniez()<amountNeeds)
            {
                if(amountNeeds-getSpendingMoniez()<30)
                {
                    return false;
                    //you clase to affording the thing
                    //just try and scrap some cash together and you got it
                }
                else
                {
                    return false;
                    //you cannot afford the thing so dont een dream of what it is like to have one
                }
            }
            else
            {
                setSpendingMoniez(getSpendingMoniez()-amountNeeds);
                return true;
                //you can afford the thing!
                //spending money is updated
            }
        }
        else return false;
    }
    


}
