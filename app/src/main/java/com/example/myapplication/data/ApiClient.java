package com.example.myapplication.data;

import com.example.myapplication.pojo.myArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static ApiClient client;
    private static ApiServer server;

    public ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        server = retrofit.create(ApiServer.class);

    }

    public static ApiClient getClient() {
        if (client == null)
            client = new ApiClient();
        return client;
    }

    public Call<myArray> getPost1(){
        return server.getPost1();
    }

    public Call<myArray> getPost2() {
        return server.getPost2();
    }

    public Call<List<myArray>> getPostQuery() {
        return server.getPostQuery(8);
    }
    public Call<myArray> setPost1(myArray array) {
        return server.setPost1(array);
    }


}
