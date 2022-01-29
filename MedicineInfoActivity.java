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

public class MedicineInfoActivity extends AppCompatActivity {

    UsersSignUp usersSignUp;
    MedicineInformation medicineInformation;

    FirebaseDatabase mDatabase;
    DatabaseReference databaseReference;

//after this pledgeActivity
Button btnNext ;
    EditText takingmedicine;
    EditText medicineName;
    EditText medicineTime;
    EditText allergicType;
    EditText allergyFood;
    EditText hospitalName;
    EditText hospitalFileNum;
    RadioButton yes1;
    RadioButton No1;
    RadioButton yes2;
    RadioButton No2;
    RadioButton yes3;
    RadioButton no3;
    RadioButton radioButton;

    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_info);

        mDatabase = FirebaseDatabase.getInstance();
        medicineInformation=new MedicineInformation();

        usersSignUp=(UsersSignUp) getIntent().getSerializableExtra("userSignup");
         btnNext=(Button)findViewById(R.id.btnNext_MedicineInfo) ;
        btnNext.setEnabled(false);

        takingmedicine=(EditText)findViewById(R.id.editTexttakeMedicineYorN);
        medicineName=(EditText)findViewById(R.id.editTextmedicineName);
        medicineTime=(EditText)findViewById(R.id.editTextMedicinTime);
        allergicType=(EditText)findViewById(R.id.editTextAllergicType);
        allergyFood=(EditText)findViewById(R.id.editText_Allergyfood);
        hospitalName=(EditText)findViewById(R.id.editTextHospitalName);
        hospitalFileNum=(EditText)findViewById(R.id.editTextFileNumber);

        yes1=findViewById(R.id.radiovc2YES_allergic);
        No1=findViewById(R.id.radiocx1NO_allergic);
        yes2=findViewById(R.id.radio_YES_Allergyfood);
        No2=findViewById(R.id.radio_NO_Allergyfood);
        yes3=findViewById(R.id.radio_YES_fileHospital);
        no3=findViewById(R.id.radio_NO_fileHospital);
        radioButton=findViewById(R.id.radioButton_ceritificMedicince);


        databaseReference = mDatabase.getReference("Medicine_Information");
        Query query=databaseReference.orderByChild("user_key");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    i=(int)dataSnapshot.getChildrenCount();

                    for (DataSnapshot user : dataSnapshot.getChildren()) {
                        MedicineInformation medicineInformation1 = user.getValue(MedicineInformation.class);
                        medicineInformation1.setKey(user.getKey());


                    }

                    if (medicineInformation == null) {
                        medicineInformation = new MedicineInformation();

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
                String y2=yes2.getText().toString();
                String n2=No2.getText().toString();
                String y3=yes3.getText().toString();
                String n3=no3.getText().toString();
                String a=radioButton.getText().toString();
                String b="not";
                if(yes1.isChecked()){
                    medicineInformation.setISheORsheHadAllergicis(y1);
                    databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);

                }else {medicineInformation.setISheORsheHadAllergicis(n1);
                    databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);}

                if(yes2.isChecked()){
                    medicineInformation.setDoesYourChildSufferAnAllergyToAnyKindOfFood(y2);
                    databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);

                }else {medicineInformation.setDoesYourChildSufferAnAllergyToAnyKindOfFood(n2);
                    databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);}

                if(yes3.isChecked()){
                    medicineInformation.setDoesYourChildHavAfileInAHospital(y3);
                    databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);

                }else {medicineInformation.setDoesYourChildHavAfileInAHospital(n3);
                    databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);}

                if(radioButton.isChecked()){
                    medicineInformation.setAcknowledgmentThatTheInformationIsCorrect(a);
                    databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);

                }else {medicineInformation.setAcknowledgmentThatTheInformationIsCorrect(b);
                    databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);}


                Intent intent = new Intent(MedicineInfoActivity.this ,pledgeActivity.class);
                intent.putExtra("userSignup",usersSignUp);
                startActivity(intent);

            }
        });*/





    }

    private void updateform(){

        String takingmedicine1 = takingmedicine.getText().toString();
        String medicineName1 = medicineName.getText().toString();
        String medicineTime1 = medicineTime.getText().toString();
        String allergicType1 = allergicType.getText().toString();
        String allergyFood1 = allergyFood.getText().toString();
        String hospitalName1 = hospitalName.getText().toString();
        String hospitalFileNum1 = hospitalFileNum.getText().toString();

        medicineInformation.setTakingMedicine(takingmedicine1);
        medicineInformation.setMedicineName(medicineName1);
        medicineInformation.setMedicineTime(medicineTime1);
        medicineInformation.setAllergicType(allergicType1);
        medicineInformation.setAllergyFood(allergyFood1);
        medicineInformation.setHospitalName(hospitalName1);
        medicineInformation.setHospitalFileNumber(hospitalFileNum1);

        medicineInformation.setUser_key(usersSignUp.getUser_name());

        Map<String, Object> postValues = medicineInformation.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(medicineInformation.getKey(), postValues);


        if (medicineInformation.getKey() == null) {
            databaseReference.child(String.valueOf(i+1)).setValue(medicineInformation);
           // DatabaseReference d = mDatabase.getReference("Medicine_Information").push();
            //medicineInformation.setKey(d.getKey());
           //d.updateChildren(postValues);
        } else
            mDatabase.getReference("Medicine_Information").updateChildren(childUpdates);
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
                Intent intent=new Intent(MedicineInfoActivity.this,AboutUsActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }


    public void actionForRadiobtn(View v) {
        switch (v.getId()){
            case R.id.radioButton_ceritificMedicince:
                btnNext.setEnabled(true);
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateform();
                        String y1=yes1.getText().toString();
                        String n1=No1.getText().toString();
                        String y2=yes2.getText().toString();
                        String n2=No2.getText().toString();
                        String y3=yes3.getText().toString();
                        String n3=no3.getText().toString();
                        String a=radioButton.getText().toString();
                        String b="not";
                        if(yes1.isChecked()){
                            medicineInformation.setISheORsheHadAllergicis(y1);
                            databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);

                        }else {medicineInformation.setISheORsheHadAllergicis(n1);
                            databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);}

                        if(yes2.isChecked()){
                            medicineInformation.setDoesYourChildSufferAnAllergyToAnyKindOfFood(y2);
                            databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);

                        }else {medicineInformation.setDoesYourChildSufferAnAllergyToAnyKindOfFood(n2);
                            databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);}

                        if(yes3.isChecked()){
                            medicineInformation.setDoesYourChildHavAfileInAHospital(y3);
                            databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);

                        }else {medicineInformation.setDoesYourChildHavAfileInAHospital(n3);
                            databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);}

                        if(radioButton.isChecked()){
                            medicineInformation.setAcknowledgmentThatTheInformationIsCorrect(a);
                            databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);

                        }else {medicineInformation.setAcknowledgmentThatTheInformationIsCorrect(b);
                            databaseReference.child(String.valueOf(i+0)).setValue(medicineInformation);}


                        Intent intent = new Intent(MedicineInfoActivity.this ,pledgeActivity.class);
                        intent.putExtra("userSignup",usersSignUp);
                        startActivity(intent);

                    }
                });

                break;
            case R.id.radioButton2:
                btnNext.setEnabled(false);
                break;

        }
    }
}