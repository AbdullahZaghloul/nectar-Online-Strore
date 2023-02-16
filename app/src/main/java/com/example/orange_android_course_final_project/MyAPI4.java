package com.example.orange_android_course_final_project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPI4 {
    String BASE_URL = "https://fakestoreapi.com/products/category/";
    @GET("electronics")
    Call<List<productModel>> getproduct4();
}
