package com.example.kindergarten;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class Fragment__B extends Fragment {

    Button b1 ;


    public Fragment__B() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Toast.makeText(getActivity(), " on craeteView", Toast.LENGTH_SHORT).show();
        View v =inflater.inflate(R.layout.fragment___b, container, false);
        // Inflate the layout for this fragment
        b1 =v.findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),picRequirement.class)); // هينا الاكشن المطلوب من الزر احططططططططة
            }
        });


        return v ;

    }
}