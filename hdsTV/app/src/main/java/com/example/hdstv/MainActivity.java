package com.example.hdstv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.hdstv.adapter.MyAdapter;
import com.example.hdstv.manager.FragmentPageManager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    private List<String> tabs;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTitles();
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.newTab();
        setPager();
        initListener();
    }

    private void initListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getId());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



    private void setPager(){
        viewPager = findViewById(R.id.view_pager);
        FragmentPageManager fragmentPageManager = new FragmentPageManager();
        viewPager.setAdapter(new MyAdapter(fragmentPageManager));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Fragment fragmentById = fragmentPageManager.findFragmentById(0);
                BaseFragment baseFragment = (BaseFragment) fragmentById;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initTitles(){
        tabs = new ArrayList<>();
        tabs.add("看电视");
        tabs.add("电影");
        tabs.add("体育");
        tabs.add("综艺");
        tabs.add("动漫");
    }
}