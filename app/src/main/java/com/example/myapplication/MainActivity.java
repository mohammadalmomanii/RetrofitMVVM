package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.data.ApiClient;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.pojo.myArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    TryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RecyclerView.LayoutManager lm = new GridLayoutManager(this, 1);
        myAdapter adapter = new myAdapter();
        binding.rv.setLayoutManager(lm);
        binding.rv.setAdapter(adapter);

        viewModel= ViewModelProviders.of(this).get(TryViewModel.class);
        viewModel.setPost1();

        viewModel.mutableLiveData.observe(this, new Observer<myArray>() {
            @Override
            public void onChanged(myArray myArray) {
                getSupportActionBar().setTitle(myArray.getTitle());
            }
        });

        viewModel.getQueryPost();
        viewModel.mutableLiveArray.observe(this, new Observer<List<myArray>>() {
            @Override
            public void onChanged(List<myArray> myArrays) {
                adapter.setList( myArrays);
            }
        });
    }
}