package com.example.hdstv.p;

import android.content.Context;
import android.util.Log;

import com.example.hdstv.bean.Poster;
import com.example.hdstv.bean.Recommend;
import com.example.hdstv.interfaces.IAllDataPresenter;
import com.example.hdstv.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MovieData implements IAllDataPresenter {
    List<Poster.Resource> posterResources;
    Context mContext;

    public MovieData(Context context){
        this.mContext = context;
    }

    @Override
    public void initData() {
        String posterJson = StringUtils.readAssetsFile("home1.json", mContext);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Poster>>(){}.getType();
        List<Poster> posters = gson.fromJson(posterJson, type);
        posterResources = posters.get(0).getResources();
    }

    @Override
    public Object getData() {
        return posterResources;
    }
}
