package com.example.hdstv;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    private Context context;
    private List<String> titles;
    private List<BaseFragment> fragmentList;

    public MyPagerAdapter(Context context ,List<BaseFragment> fragments ,List<String> titles ){
        this.context = context;
        this.titles = titles;
        this.fragmentList = fragments;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        return fragmentList.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
