package com.example.kindergarten;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class MainFragment22 extends Fragment {

    Button buttonEDIT;
    UsersLogin usersLogin;
    TextView t1,t2;
    public static final String USER_LOGIN_KEY="userLogin";
    public static final MainFragment22 newInstance(UsersLogin usersLogin){
        MainFragment22 mainFragment22=new MainFragment22();
        Bundle bundle=new Bundle();
        bundle.putSerializable(USER_LOGIN_KEY,usersLogin);
        mainFragment22.setArguments(bundle);
        return mainFragment22;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){

            usersLogin= (UsersLogin) getArguments().getSerializable(USER_LOGIN_KEY);
        }else {

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_main22,container,false); //$
        // بين السطر اللي جنبة علامة دولار  وبين الريتيرن فيو .. اسوي تعريف المكونات اللي تعودنا عليه

        usersLogin = (UsersLogin) getActivity().getIntent().getSerializableExtra("userLogin");
        buttonEDIT=view.findViewById(R.id.edit_btn);
        buttonEDIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),AccountActivity.class);
                intent.putExtra("userLogin",usersLogin);
                startActivity(intent);
            }
        });



      /*  Button btn_edit = view.findViewById(R.id.edit_btn);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),TestActivity.class));
            }
        });*/


        return view ;  //  هينا سوينا crest للفيو return  لللفيو

    }
    //  كل الللي فوق ذا السطر شي طبيعي لكل فريقمنت
//lllll
    Personal_information_for_child personal_information_for_child;
    FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        t1 = view.findViewById(R.id.nameC);
        t2=view.findViewById(R.id.classC);
        mDatabase = FirebaseDatabase.getInstance();
        databaseReference = mDatabase.getReference("personal_information_for_child");
        Query query = databaseReference.orderByChild("user_key");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    //i=(int)dataSnapshot.getChildrenCount();

                    for (DataSnapshot user : dataSnapshot.getChildren()) {
                        Personal_information_for_child personal_information_for_child1 = user.getValue(Personal_information_for_child.class);
                        Log.d("MUTEE", "Key: " + user.getKey());


                        if (personal_information_for_child1.getUser_key() != null) {
                            if (personal_information_for_child1.getUser_key().equals(usersLogin.getUser_name())) {

                                personal_information_for_child = personal_information_for_child1;
                                personal_information_for_child.setKey(user.getKey());


                                //break;
                            }
                        }
                    }


                    if (personal_information_for_child != null) {
                        t1.setText(personal_information_for_child.getFirstname());
                        t2.setText(personal_information_for_child.getClass1());

                    } else {
                        Toast.makeText(getActivity(), "Error While QR Image", Toast.LENGTH_SHORT).show();
                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Database error", Toast.LENGTH_LONG).show();

            }
        });


    }








///llllllll
}
