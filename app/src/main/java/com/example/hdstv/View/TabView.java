package com.example.hdstv.View;

import android.content.Context;
import android.util.AttributeSet;

import androidx.leanback.widget.HorizontalGridView;

public class TabView extends HorizontalGridView {



    public TabView(Context context) {
        this(context,null);
    }

    public TabView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TabView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }




}
