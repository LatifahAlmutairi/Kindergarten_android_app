package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Advertisment extends AppCompatActivity {
    EditText textAds;
    Button btn;
    ModelAdvertisment modelAdvertisment;
    FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisment);


        textAds=(EditText)findViewById(R.id.editTextAds);
        btn=(Button)findViewById(R.id.buttonAds);

        modelAdvertisment=new ModelAdvertisment();

        databaseReference=mDatabase.getInstance().getReference().child("Advertisment");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                   // i=(int) dataSnapshot.getChildrenCount();
                }else{

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelAdvertisment.setAds(textAds.getText().toString());
                databaseReference.setValue(modelAdvertisment);
            }
        });





    }

}