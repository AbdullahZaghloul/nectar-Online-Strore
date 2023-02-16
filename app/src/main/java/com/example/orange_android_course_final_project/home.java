package com.example.orange_android_course_final_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class home extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    homefragment homefragment = new homefragment();
    explorefragment explorefragment = new explorefragment();
    cartfragment cartfragment = new cartfragment();
    account accountfragment = new account();
    favouritefragment favouritefragment = new favouritefragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.botton_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homefragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.home_menu:
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, homefragment).commit();
                            return true;
                        case R.id.Explore_menu:
                            getSupportFragmentManager().beginTransaction().replace(R.id.container,explorefragment).commit();
                            return true;
                        case R.id.cart_menu:
                            getSupportFragmentManager().beginTransaction().replace(R.id.container,cartfragment).commit();
                            return true;
                        case R.id.Acount_menu:
                            getSupportFragmentManager().beginTransaction().replace(R.id.container,accountfragment).commit();
                            return true;
                        case R.id.favourite_menu:
                            getSupportFragmentManager().beginTransaction().replace(R.id.container,favouritefragment).commit();
                            return true;
                    }
                    return false;
            }
        });
    }
}