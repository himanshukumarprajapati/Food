package com.example.ncrsoft.zopac.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ncrsoft.zopac.R;
import com.example.ncrsoft.zopac.activity.MyGridActivity;
import com.example.ncrsoft.zopac.adapter.ContactAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LunchFragment extends Fragment {
    private View rootView;
    //private RecyclerView otherRecyclerView;
  //  private OtherRecycleViewAdapter otherRecycleViewAdapter;
     RecyclerView recyclerView;
     RecyclerView.Adapter adapter;
     RecyclerView.LayoutManager layoutManager;

    ArrayList<LunchFragment.Contact> list = new ArrayList<LunchFragment.Contact>();
    int[] image_id={R.drawable.electronics,R.drawable.furniture,R.drawable.appliances,
            R.drawable.bags,R.drawable.women,R.drawable.baby,
            R.drawable.men,R.drawable.homefur,R.drawable.book};

    String[] name;

    public LunchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.

        name=getResources().getStringArray(R.array.images);
        int count=0;
        for (String Name:name)
        {
            LunchFragment.Contact contact= new Contact(image_id[count],Name);
            count++;
            list.add(contact);
        }

        recyclerView=(RecyclerView)rootView.findViewById(R.id.otherGridRecucleView);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter=new ContactAdapter(list);
        recyclerView.setAdapter(adapter);
        rootView = inflater.inflate(R.layout.fragment_lunch, container, false);


        return rootView;
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

