package com.example.ncrsoft.food.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.ncrsoft.food.R;
import com.example.ncrsoft.food.adapter.GridAdapter;

public class MyGridActivity extends AppCompatActivity {
    private RecyclerView otherRecyclerView;
    private GridLayoutManager manager;
    private GridAdapter otherRecycleViewAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ImageView bookmark;
    private ImageView home;
    private ImageView ab_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_grid);



    }
}
