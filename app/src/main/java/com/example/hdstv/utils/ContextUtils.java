package com.example.hdstv.utils;

import android.app.Application;
import android.content.Context;

public class ContextUtils {

    private static Application context;

    public static void init(Application context){
        ContextUtils.context = context;
    }

    public static Context getContext(){
        return context;
    }
}
