package com.example.hdstv.View;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

public class TvTabLayout extends TabLayout {

    private final String TAG = TvTabLayout.class.getSimpleName();
    public TvTabLayout(@NonNull Context context) {
        this(context, null);
    }

    public TvTabLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TvTabLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "TvTabLayout: ");
    }

    @NonNull
    @Override
    public Tab newTab() {
        Tab tab = super.newTab();
        Log.d(TAG, "newTab: "+tab);
        tab.view.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange: "+"view "+ v +"   focus "+hasFocus);
                if(hasFocus){
                    tab.select();
                }
            }
        });
        return tab;
    }

    @Override
    public View focusSearch(View focused, int direction) {
        return super.focusSearch(focused, direction);
    }
}
