package com.example.orange_android_course_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class verification extends AppCompatActivity {

    public static final String Code = "0000";
    ImageView btnnext;
    EditText codeet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        btnnext = findViewById(R.id.codenextbtn);
        codeet = findViewById(R.id.codeEditText);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etCode  = codeet.getText().toString();
                if(etCode.equals(verification.Code)) {
                    startActivity(new Intent(verification.this, selectloaction.class));
                }
                else
                {
                    Toast.makeText(verification.this, "Wrong Code Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}