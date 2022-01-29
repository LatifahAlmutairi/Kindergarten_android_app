package com.example.kindergarten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivityAdvisor extends AppCompatActivity {

    TeacherLogin teacherLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_advisor);

        teacherLogin=(TeacherLogin)getIntent().getSerializableExtra("teacher");


        ImageView img = (ImageView) findViewById(R.id.img_std);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityAdvisor.this, MainRecyclerV.class);
                startActivity(intent);

            }
        });
        ImageView img2 = (ImageView) findViewById(R.id.img_profil);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityAdvisor.this, AdvisorAccount.class);
                intent.putExtra("teacher",teacherLogin);
                startActivity(intent);
            }
        });

        ImageView img3 = (ImageView) findViewById(R.id.img_ads);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityAdvisor.this, Advertisment.class);
                startActivity(intent);
            }
        });

    }
}

