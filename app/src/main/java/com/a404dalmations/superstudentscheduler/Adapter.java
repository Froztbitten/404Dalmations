package com.a404dalmations.superstudentscheduler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.a404dalmations.superstudentscheduler.Courses.Course;

import java.util.ArrayList;

/**
 * Created by Devon on 4/9/2017.
 */

public class Adapter extends BaseAdapter
{
    Context context;
    ArrayList<Course> courses;
    private static LayoutInflater inflater = null;

    public Adapter(Context context, ArrayList<Course> courses){
        this.context = context;
        this.courses = courses;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return courses.size();
    }

    @Override
    public Object getItem(int position){
        return courses.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        Course course = (Course) getItem(pos);
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row, null);
        TextView text = (TextView) vi.findViewById(R.id.name);
        text.setText(course.getName());
        TextView days = (TextView) vi.findViewById(R.id.days);
        String daysInput = "";
        for(Character i: course.getDays()){
            daysInput += i + " ";
        }
        days.setText(daysInput);
        TextView start = (TextView) vi.findViewById(R.id.startTime);
        start.setText(course.getStartTime().getTime());
        TextView end = (TextView) vi.findViewById(R.id.endTime);
        end.setText(course.getEndTime().getTime());
        return vi;
    }
}
