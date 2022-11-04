package com.example.hdstv;

import android.content.Context;
import android.view.View;

import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.Presenter;

public class Creator {


    public BaseGridView createGridView(View view, int resource){
        return view.findViewById(resource);
    }

}
