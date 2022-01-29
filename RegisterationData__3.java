package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterationData__3 extends AppCompatActivity {

    Personal_information_for_child p;
    MedicineInformation medicineInformation;

    private DatabaseReference databaseReference;
    private FirebaseDatabase mDatabase;
    FirebaseUser userF;
    FirebaseAuth auth;

    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;
    TextView t8;
    TextView t9;
    TextView t10;
    TextView t11;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_data__3);
        p = (Personal_information_for_child) getIntent().getSerializableExtra("ChildName");

        t1=findViewById(R.id.TextViewtakingmed);
        t2=findViewById(R.id.TextViewmedicamentName);
        t3=findViewById(R.id.TextViewWhentTake);
        t4=findViewById(R.id.TextViewAllergicYESORNO);
        t5=findViewById(R.id.TextViewAllergicTYPENEW);
        t6=findViewById(R.id.TextViewAllergyfoooodYESorNO);
        t7=findViewById(R.id.TextViewAllergyfoooodTybe);
        t8=findViewById(R.id.TextViewhospitalYESorNO);
        t9=findViewById(R.id.TextViewNamehospi);
        t10=findViewById(R.id.TextViewhospitalNumberfile);
        t11=findViewById(R.id.TextViewaleqrar);
        Button btn=findViewById(R.id.btn_o0);

        databaseReference = FirebaseDatabase.getInstance().getReference("Medicine_Information");
        final String userkey = p.getUser_key();
        Log.d("MUTEE", "USER KEY: " + userkey);
        //orderByChild("user_key").equalTo(userkey)
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Log.d("MUTEE", "onDataChange: Medicine_Information Exists");
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        MedicineInformation medicineInformation1 = child.getValue(MedicineInformation.class);
                        if (medicineInformation1.getUser_key() != null) {
                            if (medicineInformation1.getUser_key().equals(userkey)) {
                               medicineInformation = medicineInformation1;
                            }
                        }

                    }
                    if (medicineInformation != null) {
                        setMedicine_Information();
                    } else {
                        Toast.makeText(RegisterationData__3.this, "Error While Reading Medicine_Information", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Log.d("MUTEE", "onDataChange: Medicine_Information  NOT Exists");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterationData__3.this, RegisterationData__4.class);
                intent.putExtra("ChildName", p);
                startActivity(intent);

            }
        });


    }

    private void setMedicine_Information(){
        t1.setText(medicineInformation.getTakingMedicine());
        t2.setText(medicineInformation.getMedicineName());
        t3.setText(medicineInformation.getMedicineTime());
        t4.setText(medicineInformation.getISheORsheHadAllergicis());
        t5.setText(medicineInformation.getAllergicType());
        t6.setText(medicineInformation.getDoesYourChildSufferAnAllergyToAnyKindOfFood());
        t7.setText(medicineInformation.getAllergyFood());
        t8.setText(medicineInformation.getDoesYourChildHavAfileInAHospital());
        t9.setText(medicineInformation.getHospitalName());
        t10.setText(medicineInformation.getHospitalFileNumber());
        t11.setText(medicineInformation.getAcknowledgmentThatTheInformationIsCorrect());
    }

}