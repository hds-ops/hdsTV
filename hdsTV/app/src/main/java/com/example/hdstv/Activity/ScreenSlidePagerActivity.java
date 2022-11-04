package com.example.hdstv.Activity;


import static com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.hdstv.R;
import com.example.hdstv.adapter.ScreenSlidePagerAdapter;
import com.example.hdstv.fragment.ScreenSlidePageFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePagerActivity extends FragmentActivity {
    private static final int NUM_PAGES = 15;
    private ViewPager2 viewPager;
    ScreenSlidePagerAdapter pagerAdapter;
    TabLayout tabLayout;
    Context mContext = this;
    private int currTabPosition;
    private static final String TAG = ScreenSlidePagerActivity.class.getSimpleName();
    private String[] tabTextList = {"电影","综艺","动漫","游戏","直播"};


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager2);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setTabMode(MODE_SCROLLABLE);

        pagerAdapter =new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(tabTextList[position]));
        tabLayoutMediator.attach();
        tabLayout.setFocusable(true);
        tabLayout.setFocusableInTouchMode(true);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                currTabPosition = tab.getPosition();
                Log.d(TAG,"tabPosition: "+currTabPosition);
                Toast.makeText(mContext, "TAG " + tab.getPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public int getCurrTabPosition(){
        return currTabPosition;
    }


    @Override
    public void onBackPressed() {
        if(viewPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else{
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }





}
