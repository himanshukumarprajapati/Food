package com.example.ncrsoft.food.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.ncrsoft.food.R;
import com.example.ncrsoft.food.adapter.GridAdapter;

import java.util.ArrayList;

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
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.menu_baguette);
        images.add(R.drawable.menu_beer);
        images.add(R.drawable.menu_burger);
        images.add(R.drawable.menu_fish);
        images.add(R.drawable.menu_fish_and_chips);
        images.add(R.drawable.menu_fries);
        images.add(R.drawable.menu_pasta);
        images.add(R.drawable.menu_salad);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        bookmark.findViewById(R.id.star);
        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(MyGridActivity.this, MainActivity.class);
                ii.putExtra("index", 0);
                startActivity(ii);
            }
        });
        ab_search.findViewById(R.id.ab_search);
        ab_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(MyGridActivity.this, SerchActivity.class);
                ii.putExtra("index", 0);
                startActivity(ii);
            }
        });
    }
}
//        recyclerView = (RecyclerView) findViewById(R.id.horizentalList);
//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        otherRecyclerView = (RecyclerView) findViewById(R.id.otherGridRecucleView);
//        otherRecyclerView.setHasFixedSize(true);
//        otherRecyclerView = (RecyclerView) findViewById(R.id.otherGridRecucleView);
//        otherRecyclerView.setHasFixedSize(true);
//        manager = new GridLayoutManager(this, 2);
//        otherRecyclerView.setLayoutManager(manager);
//        try {
//            otherRecycleViewAdapter=new OtherRecycleViewAdapter(this,arrayList);
//            otherRecyclerView.setAdapter(otherRecycleViewAdapter);
//            otherRecyclerView.setAdapter(otherRecycleViewAdapter);
//
//        } catch (Exception e1) {
//            Log.e("error" + "  -- Adapter Exc", e1.getMessage());
//        }
//    }
//}
