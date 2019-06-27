package com.codelabss.anphoqua.finaltest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class StudentDAO {
    Context context;
    MyDBHelper myDBHelper;
    SQLiteDatabase sqLiteDatabase;

    public StudentDAO(Context context) {
        this.context = context;
        myDBHelper = new MyDBHelper(context);
    }

    public void addStudent(Student student) {
        sqLiteDatabase = myDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", student.name);
        values.put("phone", student.phone);
        sqLiteDatabase.insert("sinhvien", null, values);
    }

    public ArrayList<Student> getStudent() {
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        sqLiteDatabase = myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from sinhvien", null);

        if (cursor.moveToFirst()) {
            do {
                int _id = cursor.getInt(0);
                String name = cursor.getString(1);
                String phone = cursor.getString(2);
                Student student = new Student(_id, name, phone);
                studentArrayList.add(student);
            } while (cursor.moveToNext());
        }
        return studentArrayList;
    }

    public Student getStudent(int wannaGetItemStudent) {
        sqLiteDatabase = myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM sinhvien WHERE _id=?", new String[]{wannaGetItemStudent + ""});
        cursor.moveToFirst();
        int s_id = cursor.getInt(0);
        String s_name = cursor.getString(1);
        String s_phone = cursor.getString(2);
        Student student = new Student(s_id, s_name, s_phone);
        return student;
    }
}
