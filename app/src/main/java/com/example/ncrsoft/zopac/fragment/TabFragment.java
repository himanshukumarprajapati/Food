package com.example.ncrsoft.zopac.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ncrsoft.zopac.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3 ;

   @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View x =  inflater.inflate(R.layout.fragment_tab,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);


        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return x;
    }
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 :
                    return new ElectronicsFragment();
                case 1 :
//                    BackgroundTaskMostPopular backgroundTaskMostPopular=new BackgroundTaskMostPopular(MainActivity.class);
//                    backgroundTaskMostPopular.execute();

                    return new Appliances();
                case 2 : return new WomenFragment();
                //    case 3 : return new MotivationalFragment();

            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        /**
         * Return fragment with respect to Position .
         */
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Electronics";
                case 1 :
                    return "Appliances";
                case 2 :
                    return "Women";
//                case 3 :
//                    return "Motivational";
             }
            return null;
          }
       }

    }
