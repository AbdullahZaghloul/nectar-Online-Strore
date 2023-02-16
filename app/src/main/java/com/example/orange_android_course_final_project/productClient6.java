package com.example.orange_android_course_final_project;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class productClient6 {
    private static productClient6 instance = null;
    private MyAPI6 myAPI6;

    private productClient6()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyAPI6.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myAPI6 = retrofit.create(MyAPI6.class);
    }
    public static  synchronized productClient6 getInstance6(){
        if(instance==null) {
            instance = new productClient6();
        }
        return instance;
    }
    public MyAPI6 getMyAPI6() {return myAPI6;}
}
