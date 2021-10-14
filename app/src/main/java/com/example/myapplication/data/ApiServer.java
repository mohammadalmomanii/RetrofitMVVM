package com.example.myapplication.data;

import com.example.myapplication.pojo.myArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServer {


    @GET("posts/1")
    public Call<myArray> getPost1();

    @GET("posts/2")
    public Call<myArray> getPost2();

    @GET("posts")
    public Call<List<myArray>> getPostQuery(@Query("userId")int id);

    @POST("posts")
    public Call<myArray> setPost1(@Body myArray array);
}
