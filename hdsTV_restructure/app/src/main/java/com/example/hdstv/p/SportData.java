package com.example.hdstv.p;

import android.content.Context;

import com.example.hdstv.bean.NBATeamsName;
import com.example.hdstv.interfaces.IAllDataPresenter;
import com.example.hdstv.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SportData implements IAllDataPresenter {
    List<NBATeamsName.ResourcesDTO> sportResources;
    Context mContext;

    public SportData(Context context){
        this.mContext = context;
    }

    @Override
    public void initData() {
        String stringJson = StringUtils.readAssetsFile("nbaTeamName.json", mContext);
        Gson gson = new Gson();
        Type type = new TypeToken<NBATeamsName>(){}.getType();
        NBATeamsName sports = gson.fromJson(stringJson, type);
        sportResources = sports.getResources();
    }

    @Override
    public Object getData() {
        return sportResources;
    }

    public List<NBATeamsName.ResourcesDTO> getEastTeam(){
        List<NBATeamsName.ResourcesDTO> eastTeam = new ArrayList<>();
        for(NBATeamsName.ResourcesDTO data : sportResources){
            if(data.getRegion().equals("east")){
                eastTeam.add(data);
            }
        }
        return eastTeam;
    }
    public List<NBATeamsName.ResourcesDTO> getWestTeam(){
        List<NBATeamsName.ResourcesDTO> eastTeam = new ArrayList<>();
        for(NBATeamsName.ResourcesDTO data : sportResources){
            if(data.getRegion().equals("west")){
                eastTeam.add(data);
            }
        }
        return eastTeam;
    }
}
