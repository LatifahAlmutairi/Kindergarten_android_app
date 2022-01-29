package com.example.kindergarten;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class FragmentSecond22 extends Fragment {
    //لاززززم لكل فريقمنت احد لها اون كرييييت ولا ماراح يطلع شي
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second22, container, false);
        return view;  //  هينا سوينا crest للفيو return  لللفيو

    }

    UsersLogin usersLogin;
    public static final String USER_LOGIN_KEY = "userLogin";

    public static final FragmentSecond22 newInstance(UsersLogin usersLogin) {
        FragmentSecond22 fragmentSecond22 = new FragmentSecond22();
        Bundle bundle = new Bundle();
        bundle.putSerializable(USER_LOGIN_KEY, usersLogin);
        fragmentSecond22.setArguments(bundle);
        return fragmentSecond22;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            usersLogin = (UsersLogin) getArguments().getSerializable(USER_LOGIN_KEY);
        } else {

        }
    }

    private ImageView image;
    Personal_information_for_child personal_information_for_child;
    FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        image = view.findViewById(R.id.image);
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
                        showImage();

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

    private void showImage() {
        Glide.with(this).load(personal_information_for_child.getImageId()).into(image);
    }
}