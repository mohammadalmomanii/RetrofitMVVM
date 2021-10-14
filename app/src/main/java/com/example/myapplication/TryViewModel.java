package com.example.myapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.ApiClient;
import com.example.myapplication.pojo.myArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TryViewModel extends ViewModel {
    MutableLiveData<myArray> mutableLiveData=new MutableLiveData<>();
    MutableLiveData<List<myArray>> mutableLiveArray=new MutableLiveData<>();

    public void setPost1(){
        ApiClient.getClient().setPost1(new myArray(5,"mohammad","test")).enqueue(new Callback<myArray>() {
            @Override
            public void onResponse(Call<myArray> call, Response<myArray> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<myArray> call, Throwable t) {

            }
        });
    }
    public void getQueryPost(){
        ApiClient.getClient().getPostQuery().enqueue(new Callback<List<myArray>>() {
            @Override
            public void onResponse(Call<List<myArray>> call, Response<List<myArray>> response) {
                mutableLiveArray.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<myArray>> call, Throwable t) {

            }
        });
    }
}
