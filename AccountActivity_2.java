package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class AccountActivity_2 extends AppCompatActivity {

    UsersLogin usersLogin;
    Personal_info_for_parent personal_info_for_parent;

    FirebaseDatabase mDatabase;
    DatabaseReference databaseReference;


    EditText idType;
    EditText relationship;
    EditText nationality;
    EditText name;
    EditText endOfID;
    EditText sourceOfID;
    EditText dateofID;
    EditText workPhone;
    EditText MobileNum;
    EditText HomeNum;
    EditText relativeName1;
    EditText phoneRelative1;
    EditText addressRelative1;
    EditText relativeName2;
    EditText phoneRelative2;
    EditText addressRelative2;

    RadioButton radioButton;

    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_2);

        usersLogin = (UsersLogin) getIntent().getSerializableExtra("userLogin");

       // radioButton=(RadioButton)findViewById(R.id.radioButton222);

        mDatabase = FirebaseDatabase.getInstance();

        Button btnNxt = (Button) findViewById(R.id.next_scondActivity);
        idType = (EditText) findViewById(R.id.editTextIdtype);
        relationship = (EditText) findViewById(R.id.editTextRelation);
        nationality = (EditText) findViewById(R.id.editTextNationality);
        name = (EditText) findViewById(R.id.editTextName);
        endOfID = (EditText) findViewById(R.id.editTextEndofID);
        sourceOfID = (EditText) findViewById(R.id.editTextSourceID);
        dateofID = (EditText) findViewById(R.id.editTextDateofID);
        workPhone = (EditText) findViewById(R.id.editTextWorkphoneParent);
        HomeNum = (EditText) findViewById(R.id.editTextHomeNumParent);
        MobileNum = (EditText) findViewById(R.id.editTextMobileNumParent);
        relativeName1 = (EditText) findViewById(R.id.editTextRelativeName1);
        relativeName2 = (EditText) findViewById(R.id.editTextRelativeName2);
        phoneRelative1 = (EditText) findViewById(R.id.editTextPhoneRelative1);
        phoneRelative2 = (EditText) findViewById(R.id.editTextPhoneRelative2);
        addressRelative1 = (EditText) findViewById(R.id.editTextAddressRelative1);
        addressRelative2 = (EditText) findViewById(R.id.editTextAddressRelative2);


        databaseReference = mDatabase.getReference("personal_information_for_parent");
        Query query = databaseReference.orderByChild("user_key");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    //i=(int)dataSnapshot.getChildrenCount();

                    for (DataSnapshot user : dataSnapshot.getChildren()) {
                        Personal_info_for_parent personal_info_for_parent1 = user.getValue(Personal_info_for_parent.class);
                        Log.d("MUTEE", "Key: " + user.getKey());


                        if (personal_info_for_parent1.getUser_key() != null) {
                            if (personal_info_for_parent1.getUser_key().equals(usersLogin.getUser_name())) {

                                personal_info_for_parent = personal_info_for_parent1;
                                personal_info_for_parent.setKey(user.getKey());


                                //break;
                            }
                        }
                    }


                    if (personal_info_for_parent != null) {
                        viewData();

                    } else {
                        Toast.makeText(AccountActivity_2.this, "Error While Reading Child Information", Toast.LENGTH_SHORT).show();
                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Database error", Toast.LENGTH_LONG).show();

            }
        });

        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateform();
              /*  String a=radioButton.getText().toString();
                String b="not";

                if(radioButton.isChecked()){
                    personal_info_for_parent.setAcknowledgmentThatTheInformationIsCorrect(a);
                    databaseReference.child(String.valueOf(i+0)).setValue(personal_info_for_parent);

                }else {personal_info_for_parent.setAcknowledgmentThatTheInformationIsCorrect(b);
                    databaseReference.child(String.valueOf(i+0)).setValue(personal_info_for_parent);}*/



                Intent intent = new Intent(AccountActivity_2.this, AccountActivity_3.class);
                intent.putExtra("userLogin", usersLogin);
                startActivity(intent);
            }

        });
    }


    private void viewData() {
        idType.setText(personal_info_for_parent.getId_type());
        name.setText(personal_info_for_parent.getName());
        nationality.setText(personal_info_for_parent.getNationality());
        endOfID.setText(personal_info_for_parent.getEndOfId());
        sourceOfID.setText(personal_info_for_parent.getSourceOfId());
        dateofID.setText(personal_info_for_parent.getDateOfId());
        workPhone.setText(personal_info_for_parent.getWorkphone());
        HomeNum.setText(personal_info_for_parent.getHomephone());
        MobileNum.setText(personal_info_for_parent.getMobileNumber());
        relationship.setText(personal_info_for_parent.getRelationship());
        relativeName1.setText(personal_info_for_parent.getRelativeName1_name());
        phoneRelative1.setText(personal_info_for_parent.getRelativeName1_phone());
        addressRelative1.setText(personal_info_for_parent.getRelativeName1_address());
        relativeName2.setText(personal_info_for_parent.getRelativeName2_name());
        phoneRelative2.setText(personal_info_for_parent.getRelativeName2_phone());
        addressRelative2.setText(personal_info_for_parent.getRelativeName2_address());
    }

    private void updateform() {
        String idtype = idType.getText().toString();
        String relationship1 = relationship.getText().toString();
        String nation = nationality.getText().toString();
        String namee = name.getText().toString();
        String EndofID = endOfID.getText().toString();
        String sourceID = sourceOfID.getText().toString();
        String dateID = dateofID.getText().toString();
        String workph = workPhone.getText().toString();
        String homeph = HomeNum.getText().toString();
        String mobileph = MobileNum.getText().toString();
        String relativeName11 = relativeName1.getText().toString();
        String relativeName22 = relativeName2.getText().toString();
        String relativeph1 = phoneRelative1.getText().toString();
        String relativeph2 = phoneRelative2.getText().toString();
        String addressrelative1 = addressRelative1.getText().toString();
        String addressrelative2 = addressRelative2.getText().toString();

        personal_info_for_parent.setId_type(idtype);
        personal_info_for_parent.setRelationship(relationship1);
        personal_info_for_parent.setNationality(nation);
        personal_info_for_parent.setName(namee);
        personal_info_for_parent.setEndOfId(EndofID);
        personal_info_for_parent.setSourceOfId(sourceID);
        personal_info_for_parent.setDateOfId(dateID);
        personal_info_for_parent.setWorkphone(workph);
        personal_info_for_parent.setHomephone(homeph);
        personal_info_for_parent.setMobileNumber(mobileph);
        personal_info_for_parent.setRelativeName1_name(relativeName11);
        personal_info_for_parent.setRelativeName2_name(relativeName22);
        personal_info_for_parent.setRelativeName1_phone(relativeph1);
        personal_info_for_parent.setRelativeName2_phone(relativeph2);
        personal_info_for_parent.setRelativeName1_address(addressrelative1);
        personal_info_for_parent.setRelativeName2_address(addressrelative2);

        personal_info_for_parent.setUser_key(usersLogin.getUser_name());



        Map<String, Object> postValues = personal_info_for_parent.toMap();
        for (String s : postValues.keySet()) {
            Log.d("MUTEE", s + " : " + postValues.get(s));

        }
        ;

        Map<String, Object> childUpdates = new HashMap<>();
        Log.d("MUTEE", "updateform: " + personal_info_for_parent.getKey());
        childUpdates.put(personal_info_for_parent.getKey(), postValues);


        // if(personal_information_for_child.getKey() == null){
        //databaseReference.child(String.valueOf(i+0)).setValue(personal_information_for_child);
        //DatabaseReference d = mDatabase.getReference("personal_information_for_child").push();
        //personal_information_for_child.setKey(d.getKey());
        // d.updateChildren(postValues);

        mDatabase.getReference("personal_information_for_parent").child(personal_info_for_parent.getKey()).updateChildren(postValues).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AccountActivity_2.this, "Information updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AccountActivity_2.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Action_logout:
                FirebaseAuth.getInstance().signOut();
                finish();
                break;
            case R.id.item1:
                Intent intent=new Intent(AccountActivity_2.this,AboutUsActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }
}





