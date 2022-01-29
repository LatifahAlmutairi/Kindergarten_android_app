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

public class RegisterationData__5 extends AppCompatActivity {

    Personal_information_for_child p;

    TextView numfamily;
    TextView arrange;
    TextView brothers;
    TextView sisters;
    TextView liveWith;
    TextView otherpeople;
    TextView attendOthernursery;
    TextView favoGame;
    TextView playwith;
    TextView haveNanny;
    TextView sleepQ;
    TextView sleepPrivate;
    TextView expressFeeling;
    TextView fear;
    TextView favoriteFood;
    TextView bathroom;
    TextView needToRember;
    TextView goodbehv;
    TextView misbehv;
    TextView chidcharacters;
    TextView chrocin;
    TextView note;
    Button btn;

    ModelInterview modelInterview;


    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_data__5);

        p = (Personal_information_for_child) getIntent().getSerializableExtra("ChildName");

        numfamily=findViewById(R.id.TextViewNumfamily);
        arrange=findViewById(R.id.TextViewArrangefamily);
        brothers=findViewById(R.id.TextViewBroo);
        sisters=findViewById(R.id.TextViewSisaa);
        liveWith=findViewById(R.id.TextViewliveWith);
        otherpeople=findViewById(R.id.TextViewOtherPeople);
        attendOthernursery=findViewById(R.id.TextViewAttend);
        favoGame=findViewById(R.id.TextViewFavoGame);
        playwith=findViewById(R.id.TextVPalywith);
        haveNanny=findViewById(R.id.TextVHaveNanny);
        sleepQ=findViewById(R.id.TextVSleepQy);
        sleepPrivate=findViewById(R.id.TextVSleepPrivate);
        expressFeeling=findViewById(R.id.TextVExrpress);
        fear=findViewById(R.id.TextVFear);
        favoriteFood=findViewById(R.id.TextVFavoFood);
        bathroom=findViewById(R.id.TextVbathroom);
        needToRember=findViewById(R.id.TextVNeedRember);
        goodbehv=findViewById(R.id.TextVgoodbehv);
        misbehv=findViewById(R.id.TextVmisbbehv);
        chidcharacters=findViewById(R.id.TextVChildchara);
        chrocin=findViewById(R.id.TextVchronic);
        note=findViewById(R.id.TextVNOTE);


        databaseReference = FirebaseDatabase.getInstance().getReference("Interview");
        final String userkey = p.getUser_key();
        Log.d("MUTEE", "USER KEY: " + userkey);
        //orderByChild("user_key").equalTo(userkey)
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        ModelInterview modelInterview1 = child.getValue(ModelInterview.class);
                        if (modelInterview1.getUser_key() != null) {
                            if (modelInterview1.getUser_key().equals(userkey)) {
                                modelInterview = modelInterview1;
                            }
                        }

                    }
                    if (modelInterview != null) {
                        setinterview();
                    } else {
                        Toast.makeText(RegisterationData__5.this, "Error While Reading Interview", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Log.d("MUTEE", "onDataChange: Interview NOT Exists");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    private void setinterview(){
        numfamily.setText(modelInterview.getFamilyNum());
        arrange.setText(modelInterview.getArrange());
        brothers.setText(modelInterview.getBrothers());
        sisters.setText(modelInterview.getSisters());
        liveWith.setText(modelInterview.getLiveWith());
        otherpeople.setText(modelInterview.getPeopleAthome());
        attendOthernursery.setText(modelInterview.getOtherKindergarten());
        favoGame.setText(modelInterview.getFavoGame());
        favoriteFood.setText(modelInterview.getFavoFood());
        playwith.setText(modelInterview.getPlayWith());
        haveNanny.setText(modelInterview.getHaveNanny());
        sleepQ.setText(modelInterview.getSleepQuiet());
        sleepPrivate.setText(modelInterview.getSleepPrivate());
        expressFeeling.setText(modelInterview.getExpressFeeling());
        fear.setText(modelInterview.getFear());
        bathroom.setText(modelInterview.getDependbathroom());
        needToRember.setText(modelInterview.getNeedToRemiander());
        goodbehv.setText(modelInterview.getGoodbehavior());
        misbehv.setText(modelInterview.getChildMisbehaves());
        chidcharacters.setText(modelInterview.getChildCharacter());
        chrocin.setText(modelInterview.getChronicDiseases());
        note.setText(modelInterview.getNote());
    }
}