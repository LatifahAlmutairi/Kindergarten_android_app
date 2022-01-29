package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
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

public class Second_Full_InfoActivity extends AppCompatActivity {

    UsersSignUp usersSignUp;
    Personal_info_for_parent personal_info_for_parent;

    FirebaseDatabase mDatabase;
    DatabaseReference databaseReference;

   // RadioButton radioButton;


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
    Button btnNxt;

    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__full__info);


        mDatabase = FirebaseDatabase.getInstance();

       usersSignUp=(UsersSignUp) getIntent().getSerializableExtra("userSignup");

         btnNxt = (Button) findViewById(R.id.next_scondActivity);

         btnNxt.setEnabled(false);

       idType=(EditText)findViewById(R.id.editTextIdtype);
       relationship=(EditText)findViewById(R.id.editTextRelation);
       nationality=(EditText)findViewById(R.id.editTextNationality);
       name=(EditText)findViewById(R.id.editTextName);
       endOfID=(EditText)findViewById(R.id.editTextEndofID);
       sourceOfID=(EditText)findViewById(R.id.editTextSourceID);
       dateofID=(EditText)findViewById(R.id.editTextDateofID);
       workPhone=(EditText)findViewById(R.id.editTextWorkphoneParent);
       HomeNum=(EditText)findViewById(R.id.editTextHomeNumParent);
       MobileNum=(EditText)findViewById(R.id.editTextMobileNumParent);
       relativeName1=(EditText)findViewById(R.id.editTextRelativeName1);
       relativeName2=(EditText)findViewById(R.id.editTextRelativeName2);
       phoneRelative1=(EditText)findViewById(R.id.editTextPhoneRelative1);
       phoneRelative2=(EditText)findViewById(R.id.editTextPhoneRelative2);
       addressRelative1=(EditText)findViewById(R.id.editTextAddressRelative1);
       addressRelative2=(EditText)findViewById(R.id.editTextAddressRelative2);
      // radioButton=(RadioButton)findViewById(R.id.radioButton);

        databaseReference = mDatabase.getReference("personal_information_for_parent");
        Query query=databaseReference.orderByChild("user_key");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    i=(int)dataSnapshot.getChildrenCount();

                    for (DataSnapshot user : dataSnapshot.getChildren()) {
                        Personal_info_for_parent personal_info_for_parent1 = user.getValue(Personal_info_for_parent.class);
                        personal_info_for_parent1.setKey(user.getKey());
                        //  if (personal_information_for_child1.getUser_key().equals(usersSignUp.getKey())) {
                        //    personal_information_for_child = personal_information_for_child1;
                        //    break;
                        //  }

                    }

                    if (personal_info_for_parent == null) {
                        personal_info_for_parent = new Personal_info_for_parent();

                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Database error", Toast.LENGTH_LONG).show();

            }
        });

      /*  btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateform();

               /* String a=radioButton.getText().toString();
                String b="not";

                if(radioButton.isChecked()){
                    personal_info_for_parent.setAcknowledgmentThatTheInformationIsCorrect(a);
                    databaseReference.child(String.valueOf(i+0)).setValue(personal_info_for_parent);

                }else {personal_info_for_parent.setAcknowledgmentThatTheInformationIsCorrect(b);
                    databaseReference.child(String.valueOf(i+0)).setValue(personal_info_for_parent);}

                Intent intent = new Intent(Second_Full_InfoActivity.this ,MedicineInfoActivity.class);//MedicineInfoActivity
                intent.putExtra("userSignup",usersSignUp);
                startActivity(intent);
            }
        }); */

    }



    private void updateform(){
        String idtype=idType.getText().toString();
        String relationship1=relationship.getText().toString();
        String nation=nationality.getText().toString();
        String namee=name.getText().toString();
        String EndofID=endOfID.getText().toString();
        String sourceID=sourceOfID.getText().toString();
        String dateID=dateofID.getText().toString();
        String workph=workPhone.getText().toString();
        String homeph=HomeNum.getText().toString();
        String mobileph=MobileNum.getText().toString();
        String relativeName11=relativeName1.getText().toString();
        String relativeName22=relativeName2.getText().toString();
        String relativeph1=phoneRelative1.getText().toString();
        String relativeph2=phoneRelative2.getText().toString();
        String addressrelative1=addressRelative1.getText().toString();
        String addressrelative2=addressRelative2.getText().toString();

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

        personal_info_for_parent.setUser_key(usersSignUp.getUser_name());

        Map<String, Object> postValues = personal_info_for_parent.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put( personal_info_for_parent.getKey() , postValues);


        if(personal_info_for_parent.getKey() == null){
            databaseReference.child(String.valueOf(i+1)).setValue(personal_info_for_parent);
            //DatabaseReference d = mDatabase.getReference("ersonal_information_for_parent").push();
            //personal_info_for_parent.setKey(d.getKey());
            //d.updateChildren(postValues);
        }else
            mDatabase.getReference("personal_information_for_parent").updateChildren(childUpdates);


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
                Intent intent=new Intent(Second_Full_InfoActivity.this,AboutUsActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }

    public void actionForRadiobtn(View v) {
        switch (v.getId()){
                case R.id.radioButton1:
                    btnNxt.setEnabled(true);
                    btnNxt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            updateform();

               /* String a=radioButton.getText().toString();
                String b="not";

                if(radioButton.isChecked()){
                    personal_info_for_parent.setAcknowledgmentThatTheInformationIsCorrect(a);
                    databaseReference.child(String.valueOf(i+0)).setValue(personal_info_for_parent);

                }else {personal_info_for_parent.setAcknowledgmentThatTheInformationIsCorrect(b);
                    databaseReference.child(String.valueOf(i+0)).setValue(personal_info_for_parent);}*/

                            Intent intent = new Intent(Second_Full_InfoActivity.this ,MedicineInfoActivity.class);//MedicineInfoActivity
                            intent.putExtra("userSignup",usersSignUp);
                            startActivity(intent);
                        }
                    });
                    break;
                case R.id.radioButton2:
                    btnNxt.setEnabled(false);
                    break;

        }

    }
}