package com.example.orange_android_course_final_project;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductClient {
    private static ProductClient instance = null;
    private MyAPI myAPI;

    private ProductClient()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myAPI = retrofit.create(MyAPI.class);
    }
    public static  synchronized ProductClient getInstance(){
        if(instance==null) {
            instance = new ProductClient();
        }
        return instance;
    }
    public MyAPI getMyAPI() {return myAPI;}
}
