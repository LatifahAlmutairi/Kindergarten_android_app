package com.example.kindergarten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TestActi extends AppCompatActivity {

    private Personal_information_for_child p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        p=(Personal_information_for_child) getIntent().getSerializableExtra("ChildName");

    }


        public void btn_create_qr (View view){

            Intent intent = new Intent(TestActi.this, CreatQR.class);
            intent.putExtra("ChildName",p);
            startActivity(intent);
        }

        public void btn_Reg_data (View view){
            Intent intent = new Intent(TestActi.this, RegisterationData.class);
            intent.putExtra("ChildName",p);
            startActivity(intent);
        }

    }
