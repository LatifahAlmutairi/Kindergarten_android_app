package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignUpActivity extends AppCompatActivity {

    EditText username,password,email;
    Button done;
    ProgressBar progressBar;
    UsersSignUp usersSignUp;
    private FirebaseDatabase mDatabase;
    FirebaseAuth fAuth;
    DatabaseReference mReference;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mDatabase = FirebaseDatabase.getInstance();

        usersSignUp = (UsersSignUp) getIntent().getSerializableExtra("Users");

        username=(EditText)findViewById(R.id.username1);
        password=(EditText)findViewById(R.id.password1);
        email=(EditText)findViewById(R.id.email);
        done=(Button)findViewById(R.id.done);
        progressBar=findViewById(R.id.progressBar);

        fAuth=FirebaseAuth.getInstance();




        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),F_Full_informationActivity.class));
            finish();
        }




        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userName=username.getText().toString().trim();
                final String Email=email.getText().toString().trim();
                final String Pass=password.getText().toString().trim();


                Query usernameQuery=FirebaseDatabase.getInstance().getReference().child("Users").orderByChild("user_name").equalTo(userName);
                usernameQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                        if(dataSnapshot.getChildrenCount()>0){
                            Toast.makeText(SignUpActivity.this,"choose a different user name",Toast.LENGTH_SHORT).show();
                        }else {
                            progressBar.setVisibility(View.VISIBLE);
                            fAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){

                                        final FirebaseUser userfirebase=fAuth.getCurrentUser();
                                        userfirebase.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                            Toast.makeText(SignUpActivity.this,"Verification email has been sent",Toast.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(SignUpActivity.this,"Email not sent"+e.getMessage(),Toast.LENGTH_SHORT).show();

                                            }
                                        });
                                        final UsersSignUp user=new UsersSignUp(
                                                userName,
                                                Pass,
                                                Email
                                        );
                                        i=(int)dataSnapshot.getChildrenCount();
                                        FirebaseDatabase.getInstance().getReference("Users")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {


 // .child(FirebaseAuth.getInstance().getCurrentUser().getUid())

                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                progressBar.setVisibility(View.GONE);
                                                if (task.isSuccessful()) {



                                                    Toast.makeText(getApplicationContext(), "Registration success", Toast.LENGTH_SHORT).show();

                                                    Intent intent =new Intent(SignUpActivity.this,F_Full_informationActivity.class);

                                                    intent.putExtra("userSignup",user);
                                                    startActivity(intent);





                                                }
                                            }
                                        });

                                    }else {
                                        Toast.makeText(getApplicationContext(),"Erorr !"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                if(TextUtils.isEmpty(Email)){
                    email.setError("Email is required.");
                    return;
                }

                if (TextUtils.isEmpty(Pass)){
                    password.setError("Password is required.");
                    return;
                }

                if (Pass.length()< 6){
                    password.setError("password must be greter than or equal 6 charachters.");
                    return;
                }




            }
        });







    }
}