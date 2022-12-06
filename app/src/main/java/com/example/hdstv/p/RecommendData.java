package com.example.hdstv.p;

import android.content.Context;

import com.example.hdstv.bean.Recommend;
import com.example.hdstv.interfaces.IAllDataPresenter;
import com.example.hdstv.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class RecommendData implements IAllDataPresenter {
    Context mContext;
    List<Recommend.ResourcesDTO> recommendResources;

    public RecommendData(Context context){
        this.mContext = context;
        initData();
    }

    @Override
    public void initData() {
        String recommendJson = StringUtils.readAssetsFile("recommend.json",mContext);
        Gson gson = new Gson();
        Type type1 = new TypeToken<Recommend>(){}.getType();
        Recommend recommends = gson.fromJson(recommendJson,type1);
        recommendResources = recommends.getResources();
    }

    @Override
    public List getData() {
        return recommendResources;
    }


}
