package com.a404dalmations.superstudentscheduler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.a404dalmations.superstudentscheduler.Courses.Course;
import com.a404dalmations.superstudentscheduler.Courses.Semester;

import java.util.ArrayList;

/**
 * Created by Devon on 4/9/2017.
 */

public class SemesterAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Semester> semesters;
    private static LayoutInflater inflater = null;

    public SemesterAdapter(Context context, ArrayList<Semester> semesters){
        this.context = context;
        this.semesters = semesters;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return semesters.size();
    }

    @Override
    public Object getItem(int position){
        return semesters.get((semesters.size() - 1) - position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row2, null);

        TextView end = (TextView) vi.findViewById(R.id.semNum);
        end.setText("Semester " + pos);
        return vi;
    }
}
