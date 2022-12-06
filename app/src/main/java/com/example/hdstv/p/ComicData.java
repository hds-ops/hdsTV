package com.example.hdstv.p;

import android.content.Context;
import android.util.Log;

import com.example.hdstv.bean.Poster;
import com.example.hdstv.interfaces.IAllDataPresenter;
import com.example.hdstv.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ComicData implements IAllDataPresenter {
    List<Poster.Resource> posterResources;
    Context mContext;
    private final String TAG = ComicData.class.getSimpleName();

    public ComicData(Context context){
        this.mContext = context;
        initData();
    }

    @Override
    public void initData() {
        String posterJson = StringUtils.readAssetsFile("home1.json", mContext);
        Gson gson = new Gson();
        Log.d(TAG, "initData: " + posterJson);
        Type type = new TypeToken<ArrayList<Poster>>(){}.getType();
        List<Poster> posters = gson.fromJson(posterJson, type);
        posterResources = posters.get(1).getResources();
    }

    @Override
    public List getData() {
        return posterResources;
    }

}
