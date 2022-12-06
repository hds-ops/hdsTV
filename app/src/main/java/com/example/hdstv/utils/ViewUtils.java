package com.example.hdstv.utils;

import android.view.View;
import android.view.ViewGroup;

public class ViewUtils {

    public static View findTargetView(View rootView, Class<?> cls) {
        if (cls.isInstance(rootView)) {
            return rootView;
        }
        if (rootView instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) rootView).getChildCount(); i++) {
                View v = findTargetView(((ViewGroup) rootView).getChildAt(i), cls);
                if (v != null) {
                    return v;
                }
            }
        }
        return null;
    }

    public static int getChildIndex(View child, ViewGroup parent) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            if (parent.getChildAt(i) == child) {
                return i;
            }
        }
        return -1;
    }
}
