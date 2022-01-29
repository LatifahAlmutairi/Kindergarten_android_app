package com.example.kindergarten;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AdvisorAccount extends AppCompatActivity {

    TextView t1;
    TextView t2;
    TeacherLogin teacherLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_account);
        teacherLogin=(TeacherLogin)getIntent().getSerializableExtra("teacher");

        t1=(TextView)findViewById(R.id.advisorname);
        t2=(TextView)findViewById(R.id.jobtitle);

        t1.setText(teacherLogin.getName());
        t2.setText(teacherLogin.getJobtitle());

    }
}