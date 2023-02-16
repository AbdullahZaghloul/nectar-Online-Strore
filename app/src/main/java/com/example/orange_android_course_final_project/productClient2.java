package com.example.orange_android_course_final_project;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class productClient2 {
    private static productClient2 instance = null;
    private MyAPI2 myAPI2;

    private productClient2()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyAPI2.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myAPI2 = retrofit.create(MyAPI2.class);
    }
    public static  synchronized productClient2 getInstance(){
        if(instance==null) {
            instance = new productClient2();
        }
        return instance;
    }
    public MyAPI2 getMyAPI2() {return myAPI2;}
}
