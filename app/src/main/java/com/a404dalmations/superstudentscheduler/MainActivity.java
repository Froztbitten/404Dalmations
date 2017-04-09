package com.a404dalmations.superstudentscheduler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("Person", "");
        if(!json.equals("")){
            startActivity(new Intent(this, AccountActivity.class));
        }
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
            getSharedPreferences("name", Context.MODE_PRIVATE).edit().clear().commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void confirm(View view){
        Intent intent = new Intent(this, AccountActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String name = editText.getText().toString();
        intent.putExtra("PERSON_NAME", name);
        startActivity(intent);
    }
}