package com.example.orange_android_course_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    TextView signuptext;
    EditText email,password;
    Button loginbtn;

    public static final String EMAIL = "abdullahzaghloul022@gmail.com";
    public static final String PASSWORD = "01129527776";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signuptext = findViewById(R.id.signupid);
        email = findViewById(R.id.loginEmailId);
        password=findViewById(R.id.loginPasswordId);
        loginbtn=findViewById(R.id.loginbtn);

        signuptext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, signup.class ));
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etEmail = email.getText().toString();
                String etpassword = password.getText().toString();

                if(etEmail.equals(login.EMAIL)&&etpassword.equals(login.PASSWORD))
                {
                    startActivity(new Intent(login.this,home.class));
                }
                else
                {
                    Toast.makeText(login.this, "Login failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}