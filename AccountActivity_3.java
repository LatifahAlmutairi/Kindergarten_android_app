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

public class AccountActivity_3 extends AppCompatActivity {

    UsersLogin usersLogin;
    MedicineInformation medicineInformation;

    FirebaseDatabase mDatabase;
    DatabaseReference databaseReference;

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

    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_3);

        mDatabase = FirebaseDatabase.getInstance();
        medicineInformation = new MedicineInformation();

        usersLogin = (UsersLogin) getIntent().getSerializableExtra("userLogin");

        Button btnNext = (Button) findViewById(R.id.btnNext_MedicineInfo);

        takingmedicine = (EditText) findViewById(R.id.editTexttakeMedicineYorN);
        medicineName = (EditText) findViewById(R.id.editTextmedicineName);
        medicineTime = (EditText) findViewById(R.id.editTextMedicinTime);
        allergicType = (EditText) findViewById(R.id.editTextAllergicType);
        allergyFood = (EditText) findViewById(R.id.editText_Allergyfood);
        hospitalName = (EditText) findViewById(R.id.editTextHospitalName);
        hospitalFileNum = (EditText) findViewById(R.id.editTextFileNumber);

        yes1 = findViewById(R.id.radiovc2YES_allergic);
        No1 = findViewById(R.id.radiocx1NO_allergic);
        yes2 = findViewById(R.id.radio_YES_Allergyfood);
        No2 = findViewById(R.id.radio_NO_Allergyfood);
        yes3 = findViewById(R.id.radio_YES_fileHospital);
        no3 = findViewById(R.id.radio_NO_fileHospital);
        radioButton = findViewById(R.id.radioButton_ceritificMedicince);

        databaseReference = mDatabase.getReference("Medicine_Information");
        Query query = databaseReference.orderByChild("user_key");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    //i=(int)dataSnapshot.getChildrenCount();

                    for (DataSnapshot user : dataSnapshot.getChildren()) {
                        MedicineInformation medicineInformation1 = user.getValue(MedicineInformation.class);
                        Log.d("MUTEE", "Key: " + user.getKey());


                        if (medicineInformation1.getUser_key() != null) {
                            if (medicineInformation1.getUser_key().equals(usersLogin.getUser_name())) {

                                medicineInformation = medicineInformation1;
                                medicineInformation.setKey(user.getKey());


                                //break;
                            }
                        }
                    }


                    if (medicineInformation != null) {
                        viewData();

                    } else {
                        Toast.makeText(AccountActivity_3.this, "Error While Reading Child Information", Toast.LENGTH_SHORT).show();
                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Database error", Toast.LENGTH_LONG).show();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateform();
               // Intent intent = new Intent(AccountActivity_3.this, ActivityAfterLogin.class);
               // intent.putExtra("userLogin", usersLogin);
                // startActivity(intent);
            }

        });
    }

    private void viewData() {
        takingmedicine.setText(medicineInformation.getTakingMedicine());
        medicineTime.setText(medicineInformation.getMedicineTime());
        medicineName.setText(medicineInformation.getMedicineName());
        allergicType.setText(medicineInformation.getAllergicType());
        allergyFood.setText(medicineInformation.getAllergyFood());
        hospitalFileNum.setText(medicineInformation.getHospitalFileNumber());
        hospitalName.setText(medicineInformation.getHospitalName());
        // yes1.setText(medicineInformation.getISheORsheHadAllergicis());
        // No1.setText(medicineInformation.getISheORsheHadAllergicis());
        // yes2.setText(medicineInformation.getDoesYourChildSufferAnAllergyToAnyKindOfFood());
        // No2.set


    }

    private void updateform() {

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

        medicineInformation.setUser_key(usersLogin.getUser_name());

        Map<String, Object> postValues = medicineInformation.toMap();
        for (String s : postValues.keySet()) {
            Log.d("MUTEE", s + " : " + postValues.get(s));

        }
        ;

        Map<String, Object> childUpdates = new HashMap<>();
        Log.d("MUTEE", "updateform: " + medicineInformation.getKey());
        childUpdates.put(medicineInformation.getKey(), postValues);



        mDatabase.getReference("Medicine_Information").child(medicineInformation.getKey()).updateChildren(postValues).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AccountActivity_3.this, "Information updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AccountActivity_3.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
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
                Intent intent=new Intent(AccountActivity_3.this,AboutUsActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }
}