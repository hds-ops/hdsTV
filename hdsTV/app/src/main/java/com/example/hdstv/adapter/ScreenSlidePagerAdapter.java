package com.example.hdstv.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;

import com.example.hdstv.fragment.ScreenSlidePageFragment;

import java.util.List;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    final String TAG = ScreenSlidePagerAdapter.class.getSimpleName();

    Context mContext;

    public ScreenSlidePagerAdapter(FragmentActivity fragmentActivity){
        super(fragmentActivity);
        mContext = fragmentActivity;

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new ScreenSlidePageFragment(mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

