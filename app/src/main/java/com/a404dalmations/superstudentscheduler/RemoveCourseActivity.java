package com.a404dalmations.superstudentscheduler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class RemoveCourseActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); // Not sure if this should be here or not but whatevs.

        /** This stuff will probably have to be updated to get and update the information correctly
            in the Json. **/
        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, person.Hist.getSemesters().getSemesterNum());

        // Add the values from the array list to the spinner.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.semesterSpinner);
        sItems.setAdapter(adapter);

        // Get the number of the semester that is selected.
        int selectedSemester = (int)sItems.getSelectedItem();

       adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, person.Hist.getSemesters().get(selectedSemester).getCourses().getCourseName);

        // Add the values from the array list to the spinner.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sItems = (Spinner) findViewById(R.id.semesterSpinner);
        sItems.setAdapter(adapter);

        // Get the name of the selected semester from the spinner.
        String selectedCourse = sItems.getSelectedItem().toString();
        */

        /** Add the code to only do the next part when the button is selected. **/
        // Search the array list of courses in the selected semester to its index so that it can be
        // removed.
        /*
        for(int i = 0; i < person.Hist.getSemesters().get(selectedSemester).getCourse.size(); i ++)
        {
            if(person.Hist.getSemesters.get(selectedSemester).getCourses.get(i) == selectedCourse)
                person.Hist.getSemesters.get(selectedSemester).getCourses.remove(i);
        }
        */
    }
}