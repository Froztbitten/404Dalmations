package com.a404dalmations.superstudentscheduler;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by jonathan on 4/9/17.
 */

public class FinancialStart extends Activity {

    private float currentBalance;
    private float rentPerMonth;
    private float utilitiesSum;
    private float priviousMonthUtilities;
    private float payPerHour;
    private int hoursWorkPerWeek;
    //4.34524=weeks per mounth
    private float spendingMoniez;
    public boolean hasFoodBeenCalculated;


    public FinancialStart(float currentBalance, float rentPerMonth, float utilitiesSum, float priviousMonthUtilities, float payPerHour, int hoursWorkPerWeek, float spendingMoniez) {
        this.currentBalance = currentBalance;
        this.rentPerMonth = rentPerMonth;
        this.utilitiesSum = utilitiesSum;
        this.priviousMonthUtilities = priviousMonthUtilities;
        this.payPerHour = payPerHour;
        this.hoursWorkPerWeek = hoursWorkPerWeek;
        this.spendingMoniez = spendingMoniez;
    }

    public float getSpendingMoniez() {
        return spendingMoniez;
    }

    public void setSpendingMoniez(float spendingMoniez) {
        this.spendingMoniez = spendingMoniez;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public float getRentPerMonth() {
        return rentPerMonth;
    }

    public void setRentPerMonth(float rentPerMonth) {
        this.rentPerMonth = rentPerMonth;
    }

    public float getUtilitiesSum() {
        return utilitiesSum;
    }

    public void setUtilitiesSum(float utilitiesSum) {
        this.utilitiesSum = utilitiesSum;
    }

    public float getPriviousMonthUtilities() {
        return priviousMonthUtilities;
    }

    public void setPriviousMonthUtilities(float priviousMonthUtilities) {
        this.priviousMonthUtilities = priviousMonthUtilities;
    }

    public float getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(float payPerHour) {
        this.payPerHour = payPerHour;
    }

    public int getHoursWorkPerWeek() {
        return hoursWorkPerWeek;
    }

    public void setHoursWorkPerWeek(int hoursWorkPerWeek) {
        this.hoursWorkPerWeek = hoursWorkPerWeek;
    }


    public void amountCanSpend()
    {
        //see if the user wants to incorperate there total savings into how mutch they can spend in a week
        boolean userIntegatedSavings=false;

        //this is how much you can afford in a week not a mounth
        float expensesTotal;
        float utilTotal=0;
        int num=0;
        //you need some way of asking  for previous utility bills so we can get the average
        utilTotal=getUtilitiesSum();
        //getis the adverage amount spent on utilities per month
        utilTotal/=4.34524;
        setUtilitiesSum(utilTotal);
        //get the users rent per month
        setRentPerMonth(405);


        expensesTotal=getRentPerMonth()+getUtilitiesSum();

        //get user input for there hourly pay
        //setPayPerHour(10);
        // setHoursWorkPerWeek(20);

        float plusemonisz=getHoursWorkPerWeek()*getPayPerHour();
        float avalibleFunds=0;

        if(userIntegatedSavings==true)
        {
            avalibleFunds=(getCurrentBalance()+plusemonisz)-expensesTotal;
        }
        else
        {
            avalibleFunds=plusemonisz-expensesTotal;
        }


        setSpendingMoniez(avalibleFunds);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--- text view---
        setTitle("Can I get Some Information?");
        EditText CB = (EditText) findViewById(R.id.CB);
        EditText Rent = (EditText) findViewById(R.id.Rent);
        EditText Utility = (EditText) findViewById(R.id.Utility);
        EditText PayperH = (EditText) findViewById(R.id.PayperH);
        EditText DaysWorked = (EditText) findViewById(R.id.DaysWorked);


        String bal =CB.getText().toString();
        String r =Rent.getText().toString();
        String util = Utility.getText().toString();
        String h = PayperH.getText().toString();
        String days = DaysWorked.getText().toString();

        setCurrentBalance(Float.parseFloat(bal));
        setRentPerMonth(Float.parseFloat(r));
        setUtilitiesSum(Float.parseFloat(util));
        setPayPerHour(Integer.parseInt(h));
        setHoursWorkPerWeek(Integer.parseInt(days));

    }

}
