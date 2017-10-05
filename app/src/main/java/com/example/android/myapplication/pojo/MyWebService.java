package com.example.android.myapplication.pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyWebService {
    @GET("/cars")
    Call<List<DataBody>>  getData();

    @POST("/cars")
    Call<List<DataBody>> postData(@Body DataBody pBody);
}
