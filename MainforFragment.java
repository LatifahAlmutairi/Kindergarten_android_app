package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainforFragment extends AppCompatActivity {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfor_fragment);
    }


    public void btn_1(View view) {
        fragment =new Fragment__A();
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();
        ft.replace(R.id.fragment1,fragment);
        ft.commit();
    }

    public void btn_2(View view) {
        fragment =new Fragment__B();
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();
        ft.replace(R.id.fragment1,fragment);
        ft.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Action_logout:
                FirebaseAuth.getInstance().signOut();
                finish();
                break;
            case R.id.item1:
                Intent intent=new Intent(MainforFragment.this,AboutUsActivity.class);
                startActivity(intent);
                break;

        }

        return true;
    }

}