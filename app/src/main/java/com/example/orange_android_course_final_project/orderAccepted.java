package com.example.orange_android_course_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class orderAccepted extends AppCompatActivity {

    Button btn_trackorder;
    TextView backtohome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_accepted);
        btn_trackorder=findViewById(R.id.btn_track_order);
        backtohome=findViewById(R.id.backtohome_btn2);
        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(orderAccepted.this,home.class));
            }
        });
    }
}