package com.example.hdstv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    private List<String> tabs;
    private ViewPager viewPager;
    private BaseFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        fragment = new BaseFragment();
        tabs = new ArrayList<>();


//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                Log.d("Tag",String.valueOf(tab.getId()));
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

        setPager();
        tabLayout.setupWithViewPager(viewPager);

    }



    private void setPager(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("第" + i + "个View");
        }
        initTitles();
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyPagerAdapter(this ,fragment ,tabs));
    }

    private void initTitles(){
        tabs.add("看电视");
        tabs.add("电影");
        tabs.add("体育");
        tabs.add("综艺");
        tabs.add("动漫");
    }
}