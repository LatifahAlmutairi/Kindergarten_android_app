package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class pledgeActivity extends AppCompatActivity {

    UsersSignUp usersSignUp;
    Button btnNext;
    EditText plaedgeName;
    parentPledges parentPledges;
    FirebaseDatabase mDatabase;
    DatabaseReference databaseReference;
    RadioButton yes1;
    RadioButton No1;
    int i=0;
    //interviewActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pledge);

        mDatabase = FirebaseDatabase.getInstance();
        parentPledges=new parentPledges();

        usersSignUp=(UsersSignUp) getIntent().getSerializableExtra("userSignup");
        plaedgeName=(EditText)findViewById(R.id.editTextPledgeName);
         btnNext=(Button)findViewById(R.id.btnNext_pledgeActivity);
         btnNext.setEnabled(false);
        yes1=findViewById(R.id.ra1Yes);
        No1=findViewById(R.id.raNO);


        databaseReference = mDatabase.getReference("parent_Pledges");
        Query query=databaseReference.orderByChild("user_key");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    i=(int)dataSnapshot.getChildrenCount();

                    for (DataSnapshot user : dataSnapshot.getChildren()) {
                        parentPledges parentPledges1 = user.getValue(parentPledges.class);
                        parentPledges1 .setKey(user.getKey());


                    }

                    if (parentPledges == null) {
                        parentPledges = new parentPledges();

                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Database error", Toast.LENGTH_LONG).show();

            }
        });

       /* btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateform();
                String y1=yes1.getText().toString();
                String n1=No1.getText().toString();
                if(yes1.isChecked()){
                    parentPledges.setNO_OR_YES(y1);
                    databaseReference.child(String.valueOf(i+0)).setValue(parentPledges);

                }else {parentPledges.setNO_OR_YES(n1);
                    databaseReference.child(String.valueOf(i+0)).setValue(parentPledges);}
                Intent intent = new Intent(pledgeActivity.this ,interview.class);
                intent.putExtra("userSignup",usersSignUp);
                startActivity(intent);
            }
        });*/

    }

    private void updateform(){
        String name=plaedgeName.getText().toString();
        parentPledges.setParentpladegeName(name);
        parentPledges.setUser_key(usersSignUp.getUser_name());

        Map<String, Object> postValues = parentPledges.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(parentPledges.getKey(), postValues);


        if (parentPledges.getKey() == null) {
           databaseReference.child(String.valueOf(i+1)).setValue(parentPledges);
           // DatabaseReference d = mDatabase.getReference("parent_Pledges").push();
           // parentPledges.setKey(d.getKey());
           // d.updateChildren(postValues);
        } else
            mDatabase.getReference("parent_Pledges").updateChildren(childUpdates);
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
                Intent intent=new Intent(pledgeActivity.this,AboutUsActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }


    public void actionforradioplege(View v) {
        switch (v.getId()){
            case R.id.ra1Yes:
                btnNext.setEnabled(true);
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateform();
                        String y1=yes1.getText().toString();
                        String n1=No1.getText().toString();
                        if(yes1.isChecked()){
                            parentPledges.setNO_OR_YES(y1);
                            databaseReference.child(String.valueOf(i+0)).setValue(parentPledges);

                        }else {parentPledges.setNO_OR_YES(n1);
                            databaseReference.child(String.valueOf(i+0)).setValue(parentPledges);}
                        Intent intent = new Intent(pledgeActivity.this ,interview.class);
                        intent.putExtra("userSignup",usersSignUp);
                        startActivity(intent);
                    }
                });

                break;
            case R.id.raNO:
                btnNext.setEnabled(false);
                break;

        }


    }
}