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

public class interview extends AppCompatActivity {
//MainforFragment
    UsersSignUp usersSignUp;
    FirebaseDatabase mDatabase;
    DatabaseReference databaseReference;
    ModelInterview modelInterview;

    EditText familyNum;
    EditText Arrange;
    EditText Brothers;
    EditText Sisters;
    EditText liveWith;
    EditText peopleAthome;
    EditText otherKindergarten;
    EditText favoGame;
    EditText playWith;
    EditText haveNanny;
    EditText sleepQuiet;
    EditText sleepPrivate;
    EditText expressFeeling;
    EditText fear;
    EditText favoFood;
    EditText dependbathroom;
    EditText needToRemiander;
    EditText goodbehavior;
    EditText childMisbehaves;
    EditText childCharacter;
    EditText note;
    EditText chronicDiseases;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);

        mDatabase = FirebaseDatabase.getInstance();

        usersSignUp=(UsersSignUp) getIntent().getSerializableExtra("userSignup");

        Button btnNext=findViewById(R.id.btn_interview);
        familyNum=findViewById(R.id.editTextfamilyNum);
        Arrange=findViewById(R.id.editTextArrangeChild);
        Brothers=findViewById(R.id.edittBrothers);
        Sisters=findViewById(R.id.editSisa);
        liveWith=findViewById(R.id.editchildLive);
        peopleAthome=findViewById(R.id.ediextOtherPeople);
        otherKindergarten=findViewById(R.id.ediextOtherKindergarten);
        favoGame=findViewById(R.id.editadtFavoGame);
        favoFood=findViewById(R.id.editTFavoFood);
        playWith=findViewById(R.id.editTPlaywith);
        haveNanny=findViewById(R.id.editTextHaveNanny);
        sleepPrivate=findViewById(R.id.editSleepPrivate);
        sleepQuiet=findViewById(R.id.editTextSleepquit);
        expressFeeling=findViewById(R.id.editExpresFeeling);
        fear=findViewById(R.id.editFear);
        dependbathroom=findViewById(R.id.editTextdependPath);
        needToRemiander=findViewById(R.id.editNeedToreminder);
        goodbehavior=findViewById(R.id.editbehaveGood);
        childCharacter=findViewById(R.id.editTChildCharacteristics);
        childMisbehaves=findViewById(R.id.editchildMisbehaves);
        note=findViewById(R.id.editTextNOte);
        chronicDiseases=findViewById(R.id.editTextchronic);


        databaseReference = mDatabase.getReference("Interview");
        Query query=databaseReference.orderByChild("user_key");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    i=(int)dataSnapshot.getChildrenCount();

                    for (DataSnapshot user : dataSnapshot.getChildren()) {
                        ModelInterview modelInterview1 = user.getValue(ModelInterview.class);
                        modelInterview1.setKey(user.getKey());


                    }

                    if (modelInterview == null) {
                        modelInterview = new ModelInterview();

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
                Intent intent = new Intent(interview.this ,MainforFragment.class);
                intent.putExtra("userSignup",usersSignUp);
                startActivity(intent);
            }
        });





    }

    private void updateform(){
        String  familyNum1=familyNum.getText().toString();
        String Arrange1=Arrange.getText().toString();
        String Brothers1=Brothers.getText().toString();
        String Sisters1=Sisters.getText().toString();
        String liveWith1=liveWith.getText().toString();
        String peopleAthome1=peopleAthome.getText().toString();
        String otherKindergarten1=otherKindergarten.getText().toString();
        String favoGame1=favoGame.getText().toString();
        String playWith1=playWith.getText().toString();
        String haveNanny1=haveNanny.getText().toString();
        String sleepQuiet1=sleepQuiet.getText().toString();
        String sleepPrivate1=sleepPrivate.getText().toString();
        String expressFeeling1=expressFeeling.getText().toString();
        String fear1=fear.getText().toString();
        String favoFood1=favoFood.getText().toString();
        String dependbathroom1=dependbathroom.getText().toString();
        String needToRemiander1=needToRemiander.getText().toString();
        String goodbehavior1=goodbehavior.getText().toString();
        String childMisbehaves1=childMisbehaves.getText().toString();
        String childCharacter1=childCharacter.getText().toString();
        String note1=note.getText().toString();
        String chronicDiseases1=chronicDiseases.getText().toString();

        modelInterview.setFamilyNum(familyNum1);
        modelInterview.setArrange(Arrange1);
        modelInterview.setBrothers(Brothers1);
        modelInterview.setSisters(Sisters1);
        modelInterview.setLiveWith(liveWith1);
        modelInterview.setPeopleAthome(peopleAthome1);
        modelInterview.setOtherKindergarten(otherKindergarten1);
        modelInterview.setFavoGame(favoGame1);
        modelInterview.setPlayWith(playWith1);
        modelInterview.setHaveNanny(haveNanny1);
        modelInterview.setSleepQuiet(sleepQuiet1);
        modelInterview.setSleepPrivate(sleepPrivate1);
        modelInterview.setExpressFeeling(expressFeeling1);
        modelInterview.setFear(fear1);
        modelInterview.setFavoFood(favoFood1);
        modelInterview.setDependbathroom(dependbathroom1);
        modelInterview.setNeedToRemiander(needToRemiander1);
        modelInterview.setGoodbehavior(goodbehavior1);
        modelInterview.setChildMisbehaves(childMisbehaves1);
        modelInterview.setChildCharacter(childCharacter1);
        modelInterview.setNote(note1);
        modelInterview.setChronicDiseases(chronicDiseases1);

        modelInterview.setUser_key(usersSignUp.getUser_name());

        Map<String, Object> postValues = modelInterview.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(modelInterview.getKey(), postValues);


        if (modelInterview.getKey() == null) {
            databaseReference.child(String.valueOf(i+1)).setValue(modelInterview);
            //DatabaseReference d = mDatabase.getReference("Interview").push();
           // modelInterview.setKey(d.getKey());
            //d.updateChildren(postValues);
        } else
           mDatabase.getReference("Interview").updateChildren(childUpdates);

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
                Intent intent=new Intent(interview.this,AboutUsActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }


}