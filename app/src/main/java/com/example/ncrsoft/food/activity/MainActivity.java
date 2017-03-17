package com.example.ncrsoft.food.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.ArrayMap;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ncrsoft.food.R;
import com.example.ncrsoft.food.fragment.CallServer;
import com.example.ncrsoft.food.fragment.FriendsFragment;
import com.example.ncrsoft.food.fragment.HelpFragment;
import com.example.ncrsoft.food.fragment.LanguageFragment;
import com.example.ncrsoft.food.fragment.MessageFragment;
import com.example.ncrsoft.food.fragment.TabFragment;
import com.example.ncrsoft.food.utils.PostDataExecute;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements PostDataExecute{
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mDrawerLayout.closeDrawers();
                if (item.getItemId() == R.id.nav_home) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new TabFragment()).addToBackStack(null).commit();
                }
                if (item.getItemId() == R.id.nav_friends) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new FriendsFragment()).addToBackStack(null).commit();
                }

                if (item.getItemId() == R.id.nav_messages) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new MessageFragment()).addToBackStack(null).commit();
                }
                if (item.getItemId() == R.id.nav_discussion) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new CallServer()).addToBackStack(null).commit();
                }
                if (item.getItemId() == R.id.nav_language) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new LanguageFragment()).addToBackStack(null).commit();
                }
                if (item.getItemId() == R.id.nav_help) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new HelpFragment()).addToBackStack(null).commit();
                }
                return false;
            }
        });
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }
        public void logins(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    public void onPostRequestSuccess(int method, String resp) {
        Toast.makeText(MainActivity.this, resp, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPostRequestFailed(int method, String resp) {
        Toast.makeText(MainActivity.this, resp, Toast.LENGTH_LONG).show();

    }
}


