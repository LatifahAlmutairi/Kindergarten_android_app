package com.example.kindergarten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ContactInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
    }

    public void btn_email(View view) {
            try {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto"));
                intent.setType("message/rfc288");
                intent.putExtra(Intent.EXTRA_SUBJECT, "hello");
                intent.putExtra(Intent.EXTRA_TEXT, " Good morning");
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"someone@gmail.com"});
                startActivity(intent);
            } catch (Exception e){
                Toast.makeText(getApplicationContext(),"There is no email app", Toast.LENGTH_LONG).show();
            }

        }

}