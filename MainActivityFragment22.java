package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivityFragment22 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout ;
    ActionBarDrawerToggle actionBarDrawerToggle ;
    Toolbar toolbar ;
    NavigationView navigationView ;
    FragmentManager fragmentManager ;
    FragmentTransaction fragmentTransaction ;

    UsersLogin usersLogin;
    FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment22);

        mDatabase = FirebaseDatabase.getInstance();
        usersLogin = (UsersLogin) getIntent().getSerializableExtra("userLogin");
        //_________________________________________
        toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //_________________________________________

        drawerLayout = findViewById(R.id.drawer);
        navigationView =findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();




        //___ عشان الانتقال بين الفراقمنت
        // load default fragment   //  يعني هذا السطر للفراقمنت اللي ابي اسوي لها لود في الاكتفيتي حقتنا   // لو ماحطيته تطلع شاشه سوداء // هذي التعليقات لاسطر الفريقمنت اللي تحت

        fragmentManager =getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment,new BlankFragment22()); //  هذا اللي راح يطلع للمستخدم اول شي
        fragmentTransaction.commit() ;//
        // -----------------------------------------------------

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
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
                Intent intent=new Intent(MainActivityFragment22.this,AboutUsActivity.class);
                startActivity(intent);
                break;
            case R.id.item2:
                Intent intent1=new Intent(MainActivityFragment22.this,RulesActivity.class);
                startActivity(intent1);
                break;
            case R.id.item3:
                Intent intent2=new Intent(MainActivityFragment22.this,MapsActivity2.class);
                startActivity(intent2);
                break;
        }

        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawer(GravityCompat.START); //    هذا السطر بالذات حذيته عشان لما اضغط علي اي شي بالمنيو يقفل من نفسه
        if (menuItem.getItemId() ==R.id.home){
            fragmentManager =getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,MainFragment22.newInstance(usersLogin));//  هذا اللي راح يطلع للمستخدم اول شي
            fragmentTransaction.commit();





        }if (menuItem.getItemId() ==R.id.another){
            fragmentManager =getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, FragmentSecond22.newInstance(usersLogin)); //  هذا اللي راح يطلع للمستخدم اول شي
            fragmentTransaction.commit();
            //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv


        }if (menuItem.getItemId() ==R.id.home2){
            fragmentManager =getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new BlankFragment22()); //  هذا اللي راح يطلع للمستخدم اول شي
            fragmentTransaction.commit();

        }if (menuItem.getItemId() ==R.id.another1){
            fragmentManager =getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new ContactFragment()); //  هذا اللي راح يطلع للمستخدم اول شي
            fragmentTransaction.commit();

        }
        return true;
    }
}