package com.example.orange_android_course_final_project;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class explorefragment extends Fragment {
    CardView jewe,elec,men,women;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_explorefragment, container, false);
        jewe = v.findViewById(R.id.cardview_jewe_id);
        elec =v.findViewById(R.id.cardview_ele_id);
        men = v.findViewById(R.id.cardview_men_id);
        women=v.findViewById(R.id.cardview_women_id);

        jewe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext() , incategoryjewe.class));
            }
        });
        elec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext() , incategoryelec.class));
            }
        });
        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext() , incategorymen.class));
            }
        });
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),incategorywomen.class));
            }
        });
        return v;
    }
}