package com.example.orange_android_course_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler h= new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i =new Intent(splash_screen.this,onbording.class);
                startActivity(i);
            }
        },3000);
    }
}