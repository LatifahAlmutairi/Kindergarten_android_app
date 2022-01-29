package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.io.File;

public class ActivityAfterLogin extends AppCompatActivity {

    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        btn=findViewById(R.id.but_test);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setData(Uri.parse("mailto"));
                    intent.setType("message/rfc288");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "hello");
                    intent.putExtra(Intent.EXTRA_TEXT, " accept");
                    intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"someone@gmail.com"});
                    startActivity(intent);
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(),"There is no email app", Toast.LENGTH_LONG).show();
                }


            }
        });







    }
}