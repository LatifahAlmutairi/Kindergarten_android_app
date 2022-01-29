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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterationData__4 extends AppCompatActivity {

    Personal_information_for_child p;

    TextView t1;
    Button btn;
    private DatabaseReference databaseReference;
    private FirebaseDatabase mDatabase;

    parentPledges parentPledges;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_data__4);
        p = (Personal_information_for_child) getIntent().getSerializableExtra("ChildName");
        t1=findViewById(R.id.parent_plede);
        btn=findViewById(R.id.btn_p);


        databaseReference = FirebaseDatabase.getInstance().getReference("parent_Pledges");
        final String userkey = p.getUser_key();
        Log.d("MUTEE", "USER KEY: " + userkey);
        //orderByChild("user_key").equalTo(userkey)
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Log.d("MUTEE", "onDataChange: parent_Pledges Exists");
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        parentPledges parentPledges1 = child.getValue(parentPledges.class);
                        if (parentPledges1.getUser_key() != null) {
                            if (parentPledges1.getUser_key().equals(userkey)) {
                                parentPledges = parentPledges1;
                            }
                        }

                    }
                    if (parentPledges != null) {
                        setName();
                    } else {
                        Toast.makeText(RegisterationData__4.this, "Error While Reading parent_Pledges", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Log.d("MUTEE", "onDataChange: parent_Pledges NOT Exists");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterationData__4.this, RegisterationData__5.class);
                intent.putExtra("ChildName", p);
                startActivity(intent);

            }
        });

    }

    private void setName(){
        t1.setText(parentPledges.getParentpladegeName());
    }


}