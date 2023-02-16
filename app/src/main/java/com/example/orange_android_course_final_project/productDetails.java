package com.example.orange_android_course_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class productDetails extends AppCompatActivity {

    ImageView product_img;
    TextView product_title;
    TextView product_price;
    TextView product_disc;
    TextView detailCounter;
    Button btnaddtocart;
    TextView plus , minus;
    ImageButton fav_button;
    int counter=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Intent i = getIntent();
        product_img = findViewById(R.id.image_det_id);
        product_title = findViewById(R.id.name_det_id);
        product_price=findViewById(R.id.price_det_id);
        product_disc=findViewById(R.id.des_detail_id);
        detailCounter=findViewById(R.id.detail_counter);
        btnaddtocart = findViewById(R.id.addtocar_btn_id);
        fav_button=findViewById(R.id.favourite_btn_id);
        plus = findViewById(R.id.plus_id);
        minus=findViewById(R.id.minus_id);
        Glide.with(this).load(i.getStringExtra("product_img")).into(product_img);
        product_title.setText(i.getStringExtra("product_title"));
        product_price.setText(i.getStringExtra("product_price"));
        product_disc.setText(i.getStringExtra("product_des"));
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                detailCounter.setText(counter+"");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter==0)
                    counter=0;
                else
                    counter--;
                detailCounter.setText(counter+"");
            }
        });

        btnaddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartList.additemtoList(new cartModel(i.getStringExtra("product_img")
                        ,i.getStringExtra("product_title"),
                        detailCounter.getText().toString(),
                        i.getStringExtra("product_price")));
            }
        });
        fav_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favList.additemtoList(new favModel(i.getStringExtra("product_img")
                        ,i.getStringExtra("product_title"),
                        i.getStringExtra("product_price")));
            }
        });
    }
}