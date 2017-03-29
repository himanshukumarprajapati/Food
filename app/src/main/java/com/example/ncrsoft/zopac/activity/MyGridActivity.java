package com.example.ncrsoft.zopac.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.ncrsoft.zopac.R;
import com.example.ncrsoft.zopac.adapter.ContactAdapter;

import java.util.ArrayList;

public class MyGridActivity extends AppCompatActivity {
   // private RecyclerView otherRecyclerView;
    private GridLayoutManager manager;
   // private RecyclerView recyclerView;
   // private LinearLayoutManager layoutManager;
    private ImageView bookmark;
    private ImageView home;
    private ImageView ab_search;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Contact> list = new ArrayList<Contact>();
    int[] image_id={R.drawable.electronics,R.drawable.furniture,R.drawable.appliances,
            R.drawable.bags,R.drawable.women,R.drawable.baby,
            R.drawable.men,R.drawable.homefur,R.drawable.book};

    String[] name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_grid);

          name=getResources().getStringArray(R.array.images);

         int count=0;
        for (String Name:name)
        {
          Contact contact=new Contact(image_id[count],Name);
            count++;
            list.add(contact);
        }

        recyclerView=(RecyclerView) findViewById(R.id.otherGridRecucleView);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
     //   adapter=new ContactAdapter(list);
        recyclerView.setAdapter(adapter);



//        ArrayList<Integer> images = new ArrayList<>();
//        images.add(R.drawable.electronics);
//        images.add(R.drawable.furniture);
//        images.add(R.drawable.appliances);
//        images.add(R.drawable.bags);
//        images.add(R.drawable.women);
//        images.add(R.drawable.baby);
//        images.add(R.drawable.men);
//        images.add(R.drawable.homefur);
//        images.add(R.drawable.book);



//        otherRecyclerView = (RecyclerView) findViewById(R.id.otherGridRecucleView);
//        recyclerView.setLayoutManager(layoutManager);
//        //recyclerView.setAdapter(ap);
//        otherRecyclerView.setHasFixedSize(true);
//        manager = new GridLayoutManager(this, 2);
//        otherRecyclerView.setLayoutManager(manager);

    }


    public class Contact{
       public Contact(int image_id,String name)
       {
           this.setImage_id(image_id);
           this.setName(name);
       }

        private int image_id;
        private String name;


        public int getImage_id() {
            return image_id;
        }

        public void setImage_id(int image_id) {
            this.image_id = image_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}



//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
//        }
//        bookmark.findViewById(R.id.star);
//        bookmark.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent ii = new Intent(MyGridActivity.this, MainActivity.class);
//                ii.putExtra("index", 0);
//                startActivity(ii);
//            }
//        });
//        ab_search.findViewById(R.id.ab_search);
//        ab_search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent ii = new Intent(MyGridActivity.this, SerchActivity.class);
//                ii.putExtra("index", 0);
//                startActivity(ii);
//            }
//        });
//    }
//}
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
