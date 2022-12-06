package com.example.hdstv.p;

import android.content.Context;

import com.example.hdstv.bean.Poster;
import com.example.hdstv.interfaces.IAllDataPresenter;
import com.example.hdstv.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GameData implements IAllDataPresenter {
    Context mContext;
    List<Poster.Resource> gameResources;

    public GameData(Context context){
        this.mContext = context;
        initData();
    }

    @Override
    public void initData() {
        String posterJson = StringUtils.readAssetsFile("home1.json", mContext);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Poster>>(){}.getType();
        List<Poster> posters = gson.fromJson(posterJson, type);
        gameResources = posters.get(2).getResources();
    }

    @Override
    public List getData() {
        return gameResources;
    }

}
