package com.example.hdstv.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

public class TvTabLayout extends TabLayout {


    public TvTabLayout(@NonNull Context context) {
        this(context, null);
    }

    public TvTabLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TvTabLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
    }

    @NonNull
    @Override
    public Tab newTab() {
        Tab tab = super.newTab();
        tab.view.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    tab.select();
                }
            }
        });
        return tab;
    }
}
