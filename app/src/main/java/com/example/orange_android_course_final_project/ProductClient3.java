package com.example.orange_android_course_final_project;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductClient3 {
    private static ProductClient3 instance = null;
    private MyAPI3 myAPI3;

    private ProductClient3()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyAPI3.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myAPI3 = retrofit.create(MyAPI3.class);
    }
    public static  synchronized ProductClient3 getInstance3(){
        if(instance==null) {
            instance = new ProductClient3();
        }
        return instance;
    }
    public MyAPI3 getMyAPI3() {return myAPI3;}
}
