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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class RegisterationData_2 extends AppCompatActivity {

    Personal_information_for_child p;
    Personal_info_for_parent personal_info_for_parent;

    private DatabaseReference databaseReference;
    private FirebaseDatabase mDatabase;
    FirebaseUser userF;
    FirebaseAuth auth;

    TextView name;
    TextView relationship;
    TextView id;
    TextView idDate;
    TextView idSource;
    TextView idEnd;
    TextView nationality;
    TextView workPhone;
    TextView mobilePhone;
    TextView homePhone;
    TextView relativeName1;
    TextView relativePhone1;
    TextView relativeAddress1;
    TextView relativeName2;
    TextView relativePhone2;
    TextView relativeAddress2;

    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_data_2);
        btn = findViewById(R.id.btn_parentInfo);
        p = (Personal_information_for_child) getIntent().getSerializableExtra("ChildName");


        name = findViewById(R.id.parent_nameTecher1);
        id = findViewById(R.id.parentIDTecher2);
        relationship = findViewById(R.id.parent_RelatioTecher1);
        idDate = findViewById(R.id.parentIDDate_Techer2);
        idEnd = findViewById(R.id.parent_IDEndDateTecher1);
        idSource = findViewById(R.id.parent_IDsourceTecher1);
        nationality = findViewById(R.id.parent_NationTecher1);
        workPhone = findViewById(R.id.parent_workPHTecher1);
        homePhone = findViewById(R.id.parent_HomephTecher1);
        mobilePhone = findViewById(R.id.parent_MobilePhTecher1);
        relativeName1 = findViewById(R.id.parent_relative11Techer1);
        relativePhone1 = findViewById(R.id.parentRelativ11PHTecher1);
        relativeAddress1 = findViewById(R.id.parentRelativeAddress11Techer1);
        relativeName2 = findViewById(R.id.parent_relative22Techer1);
        relativePhone2 = findViewById(R.id.parentRelative22PhoneTecher1);
        relativeAddress2 = findViewById(R.id.parentRelativeAddress22Techer1);


        //
        //auth=FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference("personal_information_for_parent");
        final String userkey = p.getUser_key();
        Log.d("MUTEE", "USER KEY: " + userkey);
        //orderByChild("user_key").equalTo(userkey)
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Log.d("MUTEE", "onDataChange: personal_info_for_parent Exists");
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        Personal_info_for_parent personal_info_for_parent1 = child.getValue(Personal_info_for_parent.class);
                        if (personal_info_for_parent1.getUser_key() != null) {
                            if (personal_info_for_parent1.getUser_key().equals(userkey)) {
                                personal_info_for_parent = personal_info_for_parent1;
                            }
                         }

                    }
                    if (personal_info_for_parent != null) {
                        setPersonal_info_for_parent();
                    } else {
                        Toast.makeText(RegisterationData_2.this, "Error While Reading Parent Information", Toast.LENGTH_SHORT).show();
                    }

                    //personal_info_for_parent=dataSnapshot.getValue(Personal_info_for_parent.class);

                    /*if(personal_info_for_parent==null){
                        Log.d("MUTEE", "onDataChange: personal_info_for_parent ==null");
                    }else {
                        Log.d("MUTEE", "onDataChange: personal_info_for_parent !=null");
                    }*/
                } else {
                    Log.d("MUTEE", "onDataChange: personal_info_for_parent  NOT Exists");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


       /* databaseReference.orderByChild("user_key").addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if(dataSnapshot.exists()){
                   for (DataSnapshot user : dataSnapshot.getChildren()){
                       Personal_info_for_parent p1=user.getValue(Personal_info_for_parent.class);
                        p1.setUser_key(user.child("user_key").getValue().toString());
                         if (p1.getUser_key().equals(userkey)){
                           personal_info_for_parent=p1;
                           setPersonal_info_for_parent();

                         }

                   }

               }

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });*/

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterationData_2.this, RegisterationData__3.class);
                intent.putExtra("ChildName", p);
                startActivity(intent);

            }
        });


    }

    private void setPersonal_info_for_parent() {

        name.setText(personal_info_for_parent.getName());
        id.setText(personal_info_for_parent.getId_type());
        idDate.setText(personal_info_for_parent.getDateOfId());
        idEnd.setText(personal_info_for_parent.getEndOfId());
        nationality.setText(personal_info_for_parent.getNationality());
        idSource.setText(personal_info_for_parent.getSourceOfId());
        relationship.setText(personal_info_for_parent.getRelationship());
        workPhone.setText(personal_info_for_parent.getWorkphone());
        mobilePhone.setText(personal_info_for_parent.getMobileNumber());
        homePhone.setText(personal_info_for_parent.getHomephone());
        relativeName1.setText(personal_info_for_parent.getRelativeName1_name());
        relativePhone1.setText(personal_info_for_parent.getRelativeName1_phone());
        relativeAddress1.setText(personal_info_for_parent.getRelativeName1_address());
        relativeName2.setText(personal_info_for_parent.getRelativeName2_name());
        relativePhone2.setText(personal_info_for_parent.getRelativeName2_phone());
        relativeAddress2.setText(personal_info_for_parent.getRelativeName2_address());

    }


}