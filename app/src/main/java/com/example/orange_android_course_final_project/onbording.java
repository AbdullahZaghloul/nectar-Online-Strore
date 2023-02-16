package com.example.orange_android_course_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class onbording extends AppCompatActivity {

    Button getstatedbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onbording);
        getstatedbtn = findViewById(R.id.getstated_btn);

        getstatedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(onbording.this , signin.class);
                startActivity(i);
            }
        });
    }
}