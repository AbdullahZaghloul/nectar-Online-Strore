package com.example.orange_android_course_final_project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPI {
    String BASE_URL = "https://fakestoreapi.com/";
    @GET("products")
    Call<List<productModel>>getproduct();

}
