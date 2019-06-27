package com.codelabss.anphoqua.finaltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(@Nullable Context context) {
        super(context, "sv", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*
        CREATE TABLE sinhvien (
        _id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT
        )
         */

        String sql =  "CREATE TABLE sinhvien ( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT," +
                "phone TEXT)";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS sinhvien");
        onCreate(sqLiteDatabase);
    }
}
