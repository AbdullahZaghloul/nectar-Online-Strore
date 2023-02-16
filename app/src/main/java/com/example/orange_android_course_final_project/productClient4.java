package com.example.orange_android_course_final_project;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class productClient4 {
    private static productClient4 instance = null;
    private MyAPI4 myAPI4;

    private productClient4()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyAPI4.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myAPI4 = retrofit.create(MyAPI4.class);
    }
    public static  synchronized productClient4 getInstance4(){
        if(instance==null) {
            instance = new productClient4();
        }
        return instance;
    }
    public MyAPI4 getMyAPI4() {return myAPI4;}
}
