package com.codelabss.anphoqua.finaltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    Button btnAddConfirm;
    EditText editTextName, editTextPhone;
    StudentDAO studentDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        btnAddConfirm = findViewById(R.id.btnAddID);
        editTextName = findViewById(R.id.edNameID);
        editTextPhone = findViewById(R.id.edPhoneID);
        studentDAO = new StudentDAO(InsertActivity.this);

        btnAddConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newSName = editTextName.getText().toString().trim();
                String newSPhone = editTextPhone.getText().toString().trim();
                Student newStudent = new Student(newSName, newSPhone);
                studentDAO.addStudent(newStudent);

                Intent backOnMain = new Intent(InsertActivity.this, MainActivity.class);
                startActivity(backOnMain);
                finish();
            }
        });
    }
}
