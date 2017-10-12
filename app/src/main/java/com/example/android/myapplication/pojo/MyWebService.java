package com.example.android.myapplication.pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyWebService {

    @GET("/cars")
    Call<List<Car>> getData();

    @POST("/cars")
    Call<List<Car>> postData(@Body Car car);
}
