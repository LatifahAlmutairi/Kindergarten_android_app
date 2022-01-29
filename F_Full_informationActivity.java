package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
public class F_Full_informationActivity extends AppCompatActivity {

    EditText id;
    EditText nationality;
    EditText semester;
    EditText class1;
    EditText fname;
    EditText fathname;
    EditText grandname;
    EditText familyname;
    EditText palceOfBirthCountry;
    EditText dateofbirth;
    EditText passportNo;
    EditText palceOfBirthCity;
    EditText bloodtype;
    EditText houseOwnership;
    EditText region;
    EditText city;
    EditText district;
    EditText mainstreet;
    EditText street;
    EditText houseNum;
    EditText mainstreet2;
    EditText street2;
    EditText houseNum2;

    int i=0;

    UsersSignUp usersSignUp;
    Personal_information_for_child personal_information_for_child;
    FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f__full_information);




        Button btnNxt = (Button) findViewById(R.id.btnnxt);

        mDatabase = FirebaseDatabase.getInstance();
        usersSignUp = (UsersSignUp) getIntent().getSerializableExtra("userSignup");


        id = (EditText)findViewById(R.id.editTextId);
        nationality=(EditText)findViewById(R.id.editTextNation);
        semester=(EditText)findViewById(R.id.editTextSemeter);
        class1=(EditText)findViewById(R.id.editTextClass);
        fname=(EditText)findViewById(R.id.editTextfirstName);
        fathname=(EditText)findViewById(R.id.editTextfatherName);
        grandname=(EditText)findViewById(R.id.editTextGname);
        familyname=(EditText)findViewById(R.id.editTextfamily);
        palceOfBirthCountry=(EditText)findViewById(R.id.editTextPlaceofbirthCountry);
        dateofbirth=(EditText)findViewById(R.id.editTextDateofBirth);
        passportNo=(EditText)findViewById(R.id.editTextPassportNo);
        palceOfBirthCity=(EditText)findViewById(R.id.editTextPalceofbirthCity);
        bloodtype=(EditText)findViewById(R.id.editTextBloodtype);
        houseOwnership=(EditText)findViewById(R.id.editTextHouseOwnership);
        region=(EditText)findViewById(R.id.editTextRegion);
        city=(EditText)findViewById(R.id.editTextcity);
        district=(EditText)findViewById(R.id.editTextdistrict);
        mainstreet=(EditText)findViewById(R.id.editTextMainstreet);
        street=(EditText)findViewById(R.id.editTextstreet);
        houseNum=(EditText)findViewById(R.id.editTexthouseNumber);
        mainstreet2=(EditText)findViewById(R.id.editTextMainStreet22);
        street2=(EditText)findViewById(R.id.editTextStreet2);
        houseNum2=(EditText)findViewById(R.id.editTexthouseNum22);

        databaseReference = mDatabase.getReference("personal_information_for_child");
        Query query=databaseReference.orderByChild("user_key");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    i=(int)dataSnapshot.getChildrenCount();

                    for (DataSnapshot user : dataSnapshot.getChildren()) {
                        Personal_information_for_child personal_information_for_child1 = user.getValue(Personal_information_for_child.class);

                        personal_information_for_child1.setKey(user.getKey());
                        // if (personal_information_for_child1.getUser_key().equals(usersSignUp.getUser_name())) {



                        //break;
                        // }
                    }


                        if (personal_information_for_child == null) {
                            personal_information_for_child = new Personal_information_for_child();


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
            public void onClick(View v){
                    if (TextUtils.isEmpty(id.getText().toString())) {
                        id.setError(" you must fill it  ");
                    } else {
                        updateform();
                        Intent intent = new Intent(F_Full_informationActivity.this, Second_Full_InfoActivity.class);
                        intent.putExtra("userSignup", usersSignUp);
                        startActivity(intent);
                    }
                    if (TextUtils.isEmpty(nationality.getText().toString())) {
                        nationality.setError(" you must fill it  ");
                    } else {
                        updateform();
                        Intent intent = new Intent(F_Full_informationActivity.this, Second_Full_InfoActivity.class);
                        intent.putExtra("userSignup", usersSignUp);
                        startActivity(intent);
                    }
                    if (TextUtils.isEmpty(semester.getText().toString())) {
                        semester.setError(" you must fill it  ");
                    } else {
                        updateform();
                        Intent intent = new Intent(F_Full_informationActivity.this, Second_Full_InfoActivity.class);
                        intent.putExtra("userSignup", usersSignUp);
                        startActivity(intent);
                    }
                }


        });

    }



        private void updateform(){

        String idd=id.getText().toString();
        String nation=nationality.getText().toString();
        String semester1=semester.getText().toString();
        String class11=class1.getText().toString();
        String firstname=fname.getText().toString();
        String fathername=fathname.getText().toString();
        String grandname1=grandname.getText().toString();
        String familname=familyname.getText().toString();
        String birthCountry=palceOfBirthCountry.getText().toString();
        String datebirth=dateofbirth.getText().toString();
        String passNo=passportNo.getText().toString();
        String birthCity=palceOfBirthCity.getText().toString();
        String blood=bloodtype.getText().toString();
        String houseowenr=houseOwnership.getText().toString();
        String region1=region.getText().toString();
        String city1=city.getText().toString();
        String dis=district.getText().toString();
        String minSt=mainstreet.getText().toString();
        String st1=street.getText().toString();
        String houseNum1=houseNum.getText().toString();
        String minSt2=mainstreet2.getText().toString();
        String st2=street2.getText().toString();
        String houseNum22=houseNum2.getText().toString();

        personal_information_for_child.setID(idd);
        personal_information_for_child.setNationality(nation);
        personal_information_for_child.setSemester(semester1);
        personal_information_for_child.setClass1(class11);
        personal_information_for_child.setFirstname(firstname);
        personal_information_for_child.setFathername(fathername);
        personal_information_for_child.setGrandfathername(grandname1);
        personal_information_for_child.setFamilyname(familname);
        personal_information_for_child.setPlaceOfbirthCountry(birthCountry);
        personal_information_for_child.setBirthDate(datebirth);
        personal_information_for_child.setPassportnumber(passNo);
        personal_information_for_child.setPlaceOfbirthCity(birthCity);
        personal_information_for_child.setBloodtype(blood);
        personal_information_for_child.setHouseOwnership(houseowenr);
        personal_information_for_child.setTheAdministrativeRegion(region1);
        personal_information_for_child.setCity(city1);
        personal_information_for_child.setDistrict(dis);
        personal_information_for_child.setMainStreet(minSt);
        personal_information_for_child.setMainStreet2(minSt2);
        personal_information_for_child.setStreet(st1);
        personal_information_for_child.setStreet2(st2);
        personal_information_for_child.setHousenumber(houseNum1);
        personal_information_for_child.setHousenumber2(houseNum22);

        personal_information_for_child.setUser_key(usersSignUp.getUser_name());

            Map<String, Object> postValues = personal_information_for_child.toMap();

            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put( personal_information_for_child.getKey() , postValues);

            if(personal_information_for_child.getKey() == null){
                databaseReference.child(String.valueOf(i+1)).setValue(personal_information_for_child);
                //DatabaseReference d = mDatabase.getReference("personal_information_for_child").push();
                //personal_information_for_child.setKey(d.getKey());
               //d.updateChildren(postValues);
            }else
                mDatabase.getReference("personal_information_for_child").updateChildren(childUpdates);
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
                Intent intent=new Intent(F_Full_informationActivity.this,AboutUsActivity.class);
                startActivity(intent);
                break;

            }

        return true;
    }


}






