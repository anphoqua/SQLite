package com.codelabss.anphoqua.finaltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    ListView listView;
    ArrayList<Student> arrayList;
    StudentDAO studentDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAddStudentID);
        listView = findViewById(R.id.lvStudentID);
        studentDAO = new StudentDAO(MainActivity.this);

        updateListView();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goInsert = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(goInsert);
            }
        });









    }

    public void updateListView(){
        arrayList = studentDAO.getStudent();

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, arrayList);
        listView.setAdapter(myAdapter);
    }
}
