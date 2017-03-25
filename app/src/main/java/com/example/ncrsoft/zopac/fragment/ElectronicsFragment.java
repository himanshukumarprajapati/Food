package com.example.ncrsoft.zopac.fragment;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.renderscript.Sampler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ncrsoft.zopac.R;
import com.example.ncrsoft.zopac.adapter.OtherRecycleViewAdapter;
import com.example.ncrsoft.zopac.utils.ConnectionManager;
import com.example.ncrsoft.zopac.utils.ExecutePostRequest;
import com.example.ncrsoft.zopac.utils.PostDataExecute;
import com.google.gson.Gson;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElectronicsFragment extends Fragment implements PostDataExecute{
    private View rootView;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView otherRecyclerView;
    private View loadMoreFooter;
    private GridLayoutManager manager;
    private OtherRecycleViewAdapter otherRecycleViewAdapter;
    private ArrayList<MyPojo> arrayList = new ArrayList<>();

    public ElectronicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView=inflater.inflate(R.layout.fragment_electronics, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressOther);
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.otherSwipeLayout);
        otherRecyclerView = (RecyclerView) rootView.findViewById(R.id.otherGridRecucleView);
        otherRecyclerView.setHasFixedSize(true);
        manager = new GridLayoutManager(getActivity(), 2);
        otherRecyclerView.setLayoutManager(manager);
        otherRecyclerView.setAdapter(otherRecycleViewAdapter);
        loadMoreFooter = rootView.findViewById(R.id.include_load_more_footer);
        Boolean isInternet = ConnectionManager.isNetworkOnline(getActivity());
        try {
            otherRecycleViewAdapter=new OtherRecycleViewAdapter(getActivity(),arrayList);
            otherRecyclerView.setAdapter(otherRecycleViewAdapter);

        }catch (Exception e) {

        }
        if (isInternet) {
            progressBar.setVisibility(View.VISIBLE);

            RequestBody formBody = new FormEncodingBuilder()
                    .add("category_name", "noticias")
                    .add("page", String.valueOf(1))
                    .build();
            // Gson gson = new Gson();
            // String JsonBody = gson.toJson(new Body(name, page + ""));
            new ExecutePostRequest(getActivity(), 1, formBody, this,"").execute("http://api.zopac.in/api/category");


        } else {
            final Toast tag = Toast.makeText(getActivity().getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT);
            tag.show();
            new CountDownTimer(9000, 1000) {
                public void onTick(long millisUntilFinished) {
                    tag.show();
                }

                public void onFinish() {
                    tag.show();
                }
            }.start();

        }
        return rootView;
    }

    @Override
    public void onPostRequestSuccess(int method, String resp) {
        try{
            Gson gson = new Gson();

//       myPoJoModels=gson.fromJson(resp,MyPojo.class);
//       myPoJoModels.getActors();

            MyPojo my = gson.fromJson(resp,MyPojo.class);
           // Log.e("DATATATATA", my);
            arrayList.add(my);
            progressBar.setVisibility(View.GONE);
            otherRecycleViewAdapter.notifyDataSetChanged();
        }catch (Exception e){

        }
    }

    @Override
    public void onPostRequestFailed(int method, String resp) {

    }

    public class MyPojo
          {
          private String StatusCode;
          private String CategoryName;
          private String CategoryId;

            public MyPojo(String statusCode, String categoryName, String categoryId) {
                this.StatusCode = statusCode;
                this.CategoryName = categoryName;
                this.CategoryId = categoryId;
            }
        public String getStatusCode ()
        {
            return StatusCode;
        }

        public void setStatusCode (String StatusCode)
        {
            this.StatusCode = StatusCode;
        }

        public String getCategoryName ()
        {
            return CategoryName;
        }

        public void setCategoryName (String CategoryName)
        {
            this.CategoryName = CategoryName;
        }

        public String getCategoryId ()
        {
            return CategoryId;
        }

        public void setCategoryId (String CategoryId)
        {
            this.CategoryId = CategoryId;
        }

       }
}
