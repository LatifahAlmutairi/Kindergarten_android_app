package com.example.kindergarten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterationData extends AppCompatActivity {

    TextView childName1;
    TextView childName2;
    TextView childName3;
    TextView childName4;
    TextView class1;
    TextView semester;
    TextView nationality;
    TextView id;
    TextView passportNum;
    TextView birthDate;
    TextView placeBirthCountry;
    TextView placeBirthCity;
    TextView bloodType;
    TextView homeOwenrship;
    TextView AdiminiDistict;
    TextView neighborhood;
    TextView City;
    TextView mainSt1;
    TextView subSt1;
    TextView mainSt2;
    TextView subSt2;
    TextView homeNo1;
    TextView homeNo2;

    Personal_information_for_child personal_information_for_child;
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_data);

        personal_information_for_child=(Personal_information_for_child)getIntent().getSerializableExtra("ChildName");

        btn=findViewById(R.id.btn_childInfo);

        childName1=findViewById(R.id.Child_nameTecher1);
        childName2=findViewById(R.id.Child_nameTecher2);
        childName3=findViewById(R.id.Child_nameTecher3);
        childName4=findViewById(R.id.Child_nameTecher4);
        class1=findViewById(R.id.Child_classTecher1);
        semester=findViewById(R.id.Child_classTecher2);
        nationality=findViewById(R.id.Child_NationTecher1);
        id=findViewById(R.id.Child_IDTecher2);
        bloodType=findViewById(R.id.Child_bloodTypeTecher1);
        birthDate=findViewById(R.id.Child_BirthDateTecher1);
        placeBirthCity=findViewById(R.id.Child_BirthCityTecher1);
        placeBirthCountry=findViewById(R.id.Child_BirthCountryTecher1);
        passportNum=findViewById(R.id.Child_PassportTecher1);
        homeOwenrship=findViewById(R.id.Child_HomeownershipTecher1);
        AdiminiDistict=findViewById(R.id.Child_AdministrativeTecher1);
        neighborhood=findViewById(R.id.Child_neighborhoodTecher1);
        City=findViewById(R.id.Child_CityTecher1);
        mainSt1=findViewById(R.id.Child_MainStreerTecher1);
        mainSt2=findViewById(R.id.Child_Mainstreet22Techer1);
        subSt1=findViewById(R.id.Child_SubstreetTecher1);
        subSt2=findViewById(R.id.Child_SubStreet22Techer1);
        homeNo1=findViewById(R.id.Child_HomeNumTecher1);
        homeNo2=findViewById(R.id.Child_HomeNum22Techer1);


        /////

        childName1.setText(personal_information_for_child.getFirstname());
        childName2.setText(personal_information_for_child.getFathername());
        childName3.setText(personal_information_for_child.getGrandfathername());
        childName4.setText(personal_information_for_child.getFamilyname());
        class1.setText(personal_information_for_child.getClass1());
        semester.setText(personal_information_for_child.getSemester());
        nationality.setText(personal_information_for_child.getNationality());
        id.setText(personal_information_for_child.getID());
        bloodType.setText(personal_information_for_child.getBloodtype());
        birthDate.setText(personal_information_for_child.getBirthDate());
        placeBirthCountry.setText(personal_information_for_child.getPlaceOfbirthCountry());
        placeBirthCity.setText(personal_information_for_child.getPlaceOfbirthCity());
        passportNum.setText(personal_information_for_child.getPassportnumber());
        homeOwenrship.setText(personal_information_for_child.getHouseOwnership());
        neighborhood.setText(personal_information_for_child.getDistrict());
        City.setText(personal_information_for_child.getCity());
        AdiminiDistict.setText(personal_information_for_child.getTheAdministrativeRegion());
        mainSt2.setText(personal_information_for_child.getMainStreet2());
        mainSt1.setText(personal_information_for_child.getMainStreet());
        subSt1.setText(personal_information_for_child.getStreet());
        subSt2.setText(personal_information_for_child.getStreet2());
        homeNo1.setText(personal_information_for_child.getHousenumber());
        homeNo2.setText(personal_information_for_child.getHousenumber2());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterationData.this,RegisterationData_2.class);
                intent.putExtra("ChildName",personal_information_for_child);
                startActivity(intent);
            }
        });

    }
}