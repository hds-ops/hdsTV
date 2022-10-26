package com.example.hdstv.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.hdstv.BaseFragment;

public class MyAdapter extends FragmentStatePagerAdapter {

    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = new BaseFragment();
        return (Fragment) fragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
