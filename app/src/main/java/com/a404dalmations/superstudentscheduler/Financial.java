package com.a404dalmations.superstudentscheduler;

/**
 * Created by jonathan on 4/8/17.
 */

public class Financial {

    private float currentBalance;
    private float rentPerMonth;
    private float utilitiesSum;
    private float priviousMonthUtilities;
    private float payPerHour;
    private int hoursWorkPerWeek;
    //4.34524=weeks per mounth
    private float spendingMoniez;
    public boolean hasFoodBeenCalculated;


    public Financial(float currentBalance, float rentPerMonth, float utilitiesSum, float priviousMonthUtilities, float payPerHour, int hoursWorkPerWeek, float spendingMoniez) {
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
        while(priviousMonthUtilities!=-1)
        {
            utilTotal+=priviousMonthUtilities+utilTotal;
            num++;
        }
        utilTotal/=num;
        //getis the adverage amount spent on utilities per month
        utilTotal/=4.34524;
        setUtilitiesSum(utilTotal);
        //get the users rent per month
       setRentPerMonth(405);


        expensesTotal=getRentPerMonth()+getUtilitiesSum();

        //get user input for there hourly pay
        setPayPerHour(10);
        setHoursWorkPerWeek(20);

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


    public boolean canYouAffordFood()
    {
        //get the users amount needs for foods
        float amountNeeds=0;
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

    public boolean canYouAffordStuff()
    {
        //how much is the thing
        float amountNeeds=0;
        if(hasFoodBeenCalculated==false)
        {
            //no you cant afford food so you cant afford stuff
            if(canYouAffordFood()==false)
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
