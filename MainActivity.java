package com.example.kindergarten;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

  private   EditText userName, password;
  private    Button btnLogin;
  private   Button btnSignUp;
   private   TextView forgetPass;
   private   ProgressBar progressBar;
 private DatabaseReference databaseReference;
     FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userName=(EditText) findViewById(R.id.username1);
        password= (EditText) findViewById(R.id.password1);
        btnLogin=(Button)findViewById(R.id.but_login);
        btnSignUp=(Button)findViewById(R.id.signUp);
        forgetPass=(TextView)findViewById(R.id.textViewForgetPass);
        progressBar=findViewById(R.id.progressBar);
        fAuth=FirebaseAuth.getInstance();


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
            }
        });

        //login

        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference("Users");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username=MainActivity.this.userName.getText().toString();
                final String pass=password.getText().toString();

                if(TextUtils.isEmpty(username)){
                    Toast.makeText(getApplicationContext(), "Enter user name", Toast.LENGTH_SHORT).show();
                return;}
                if (TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                Query query=databaseReference.orderByChild("user_name").equalTo(username);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            for (DataSnapshot user : dataSnapshot.getChildren()) {
                                UsersLogin userB=user.getValue(UsersLogin.class);
                                userB.setKey(user.getKey());
                                 assert userB != null;
                                if (userB.getPassword().equals(pass.trim())){
                                    Intent intent=new Intent(getApplicationContext(),MainActivityFragment22.class);
                                    intent.putExtra("userLogin",userB);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(getApplicationContext(), "Password wrong", Toast.LENGTH_LONG).show();
                                }
                            }


                        }else{
                            DatabaseReference teacherRef=database.getReference("teachers");
                            Query query1=teacherRef.orderByChild("user_name").equalTo(username);
                            query1.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists())  {
                                    for (DataSnapshot user : dataSnapshot.getChildren())   {
                                        TeacherLogin userBean=user.getValue(TeacherLogin.class);
                                        userBean.setKey(user.getKey());
                                        assert userBean != null;
                                        if(userBean.getPassword().equals(pass.trim())){
                                            Intent intent=new Intent(getApplicationContext(),MainActivityAdvisor.class);
                                            intent.putExtra("teacher",userBean);
                                            startActivity(intent);
                                        }else {
                                            Toast.makeText(getApplicationContext(), "Password wrong", Toast.LENGTH_LONG).show();
                                        }

                                    }
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
                                }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                    Toast.makeText(getApplicationContext(), "Database error", Toast.LENGTH_LONG).show();

                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Database error", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText resetMail=new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog =new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter your email to received reset link. ");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract the email and send link
                        String mail=resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                               Toast.makeText(getApplicationContext(),"Reset link sent to your email.",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Error ! Resst link is not sent."+e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     //close dialog
                    }
                });

                passwordResetDialog.create().show();
            }
        });





    }
}
