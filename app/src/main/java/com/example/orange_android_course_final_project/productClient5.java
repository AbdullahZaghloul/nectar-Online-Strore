package com.example.orange_android_course_final_project;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class productClient5 {
    private static productClient5 instance = null;
    private MyAPI5 myAPI5;

    private productClient5()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyAPI5.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myAPI5 = retrofit.create(MyAPI5.class);
    }
    public static  synchronized productClient5 getInstance5(){
        if(instance==null) {
            instance = new productClient5();
        }
        return instance;
    }
    public MyAPI5 getMyAPI5() {return myAPI5;}
}
