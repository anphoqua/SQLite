package com.codelabss.anphoqua.finaltest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> studentArrayList;

    public MyAdapter(Context context, ArrayList<Student> studentArrayList) {
        this.context = context;
        this.studentArrayList = studentArrayList;
    }

    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        view = layoutInflater.inflate(R.layout.one_student, null);
        TextView textView_name = view.findViewById(R.id.tvStudentNameID);
        TextView textView_phone = view.findViewById(R.id.tvStudentPhoneID);

        final Student student = studentArrayList.get(i);
        textView_name.setText(student.name);
        textView_phone.setText(student.phone);

        return view;
    }
}
