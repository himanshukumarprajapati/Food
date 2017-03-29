package com.example.ncrsoft.zopac.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.ncrsoft.zopac.R;
import com.example.ncrsoft.zopac.utils.ArraysContainer;
import com.example.ncrsoft.zopac.utils.ExecuteBackground;
import com.example.ncrsoft.zopac.utils.PostDataExecute;
import com.example.ncrsoft.zopac.utils.Pref;
import com.google.gson.Gson;

import java.util.ArrayList;

//import com.example.ncrsoft.food.R;

public class Splash extends AppCompatActivity{
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
//        }
//        setContentView(R.layout.activity_splash);
//        new ExecuteBackground(Splash.this, 1).execute("api.zopac.in/api/category");
//    }
//
//    @Override
//    public void onPostRequestSuccess(int method, String resp) {
//        Gson gson = new Gson();
//        MyPojoCategory  myPojoCategoty[]= gson.fromJson(resp,MyPojoCategory[].class);
//        ArrayList<MyPojoCategory> dd = new ArrayList<>();
//        for(int i = 1;i<myPojoCategoty.length;i++){
//            dd.add(myPojoCategoty[i]);
//        }
//        ArraysContainer.TableData.addAll(dd);
//        if(new Pref(Splash.this).getUserName("user","r").equalsIgnoreCase("r")) {
//            startActivity(new Intent(Splash.this, LoginActivity.class));
//            finish();
//        } else{
//            startActivity(new Intent(Splash.this, MyGridActivity.class));
//            finish();
//        }
//    }
//
//    @Override
//    public void onPostRequestFailed(int method, String resp) {
//
//    }
//
//
//    public class MyPojoCategory
//        {
//        private String StatusCode;
//
//        private String CategoryName;
//
//        private String CategoryId;
//
//        public String getStatusCode ()
//        {
//            return StatusCode;
//        }
//
//        public void setStatusCode (String StatusCode)
//        {
//            this.StatusCode = StatusCode;
//        }
//
//        public String getCategoryName ()
//        {
//            return CategoryName;
//        }
//
//        public void setCategoryName (String CategoryName)
//        {
//            this.CategoryName = CategoryName;
//        }
//
//        public String getCategoryId ()
//        {
//            return CategoryId;
//        }
//
//        public void setCategoryId (String CategoryId)
//        {
//            this.CategoryId = CategoryId;
//        }
//
//       }
}
