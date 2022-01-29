package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewAds extends AppCompatActivity {

    DatabaseReference databaseReference;
    ModelAdvertisment modelAdvertisment;

    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ads);

        t1=(TextView)findViewById(R.id.textViewAds);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference=database.getReference("Advertisment");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ModelAdvertisment modelAdvertisment1=dataSnapshot.getValue(ModelAdvertisment.class);
                t1.setText(modelAdvertisment1.getAds());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}