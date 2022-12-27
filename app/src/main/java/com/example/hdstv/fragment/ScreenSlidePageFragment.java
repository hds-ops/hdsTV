package com.example.hdstv.fragment;


import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.FocusHighlightHelper;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

import com.example.hdstv.Presenter.MyHeaderPresenter;
import com.example.hdstv.Presenter.MyListRowPresenter;
import com.example.hdstv.Presenter.PosterPresenter;
import com.example.hdstv.Presenter.RecommendPresenter;
import com.example.hdstv.Presenter.SportsPresenter;
import com.example.hdstv.bean.Block;
import com.example.hdstv.bean.NBATeamsName;
import com.example.hdstv.bean.Poster;
import com.example.hdstv.bean.Recommend;
import com.example.hdstv.bean.RowConfig;
import com.example.hdstv.listener.ItemClickable;
import com.example.hdstv.p.ComicData;
import com.example.hdstv.p.GameData;
import com.example.hdstv.p.MovieData;
import com.example.hdstv.p.RecommendData;
import com.example.hdstv.p.SportData;
import com.example.hdstv.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePageFragment extends RowsSupportFragment {

    Context mContext;
    private ArrayObjectAdapter arrayObjectAdapter;
    private ClassPresenterSelector presenterSelector;
    private MyHeaderPresenter mHeaderPresenter;
    private MyListRowPresenter listRowPresenter;
    private List<Poster> posters;
    private Handler mUiHandler = new Handler();

    public int curTabPosition;
    public static final int COLUMNS = 5;
    private static final String TAG = ScreenSlidePageFragment.class.getSimpleName();

    public ScreenSlidePageFragment(Context context){
        mContext = context;
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("ScreenSlidePagerActivity", "onCreate: getContext" + getContext());

        initMyListRowPresenter();
        arrayObjectAdapter = new ArrayObjectAdapter(listRowPresenter);
        getVerticalGridView().setVerticalSpacing(40);
        getVerticalGridView().setPadding(90,56,90,120);
        setAdapter(arrayObjectAdapter);


        try {
            initPresenterSelector();
            initPoster();

            Log.d(TAG, "onViewCreated: " + getVerticalGridView().getChildAt(0));
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG,"err: "+e.getMessage());
        }

    }

    private void initMyListRowPresenter() {
        listRowPresenter = new MyListRowPresenter();
        listRowPresenter.addRowConfig(Poster.class, new RowConfig(new RowConfig.RowMargin(-8, 0), 4, 0));
        listRowPresenter.addRowConfig(Recommend.class, new RowConfig(new RowConfig.RowMargin(47,40), 7,0));
        mHeaderPresenter = new MyHeaderPresenter(mContext);
        listRowPresenter.setHeaderPresenter(mHeaderPresenter);

        listRowPresenter.setSelectEffectEnabled(false);

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void notifyData(int currentPosition){
        arrayObjectAdapter.clear();
        this.curTabPosition = currentPosition;
        switch(currentPosition){
            case 0:
                initRecommend();
                initPoster();
                break;
            case 1:
                initComic();
                break;
            case 2:
                initGame();
                break;
            case 3:
                initSport();
                break;
            default:break;
        }

    }


    private void initPresenterSelector(){
        presenterSelector = new ClassPresenterSelector();
        presenterSelector.addClassPresenter(Recommend.ResourcesDTO.class,new RecommendPresenter(mContext));
        presenterSelector.addClassPresenter(Poster.Resource.class,new PosterPresenter());
        presenterSelector.addClassPresenter(NBATeamsName.ResourcesDTO.class,new SportsPresenter());

        OnItemViewClickedListener mClickListener = new OnItemViewClickedListener() {
            @Override
            public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
                if(item instanceof Recommend.ResourcesDTO){
                    onRecommendClick((Recommend.ResourcesDTO)item);
                }
            }
        };

        for (Presenter p: presenterSelector.getPresenters()) {
            if(p instanceof ItemClickable){
                ((ItemClickable)p).setOnItemClickListener(mClickListener);
            }
        }

    }


    private void initRecommend(){
        RecommendData recommendData = new RecommendData(mContext);
        Log.d(TAG, "initRecommend: " + recommendData.getData().toString());
        listRowPresenter.addRowConfig(Recommend.class, new RowConfig(new RowConfig.RowMargin(47,40), 7,0));
        Block<Recommend.ResourcesDTO> recommendDataBlock = new Block<>(null, recommendData.getData(),8);
        recommendDataBlock.createRows(presenterSelector);
        Log.d(TAG,"rowSize: "+recommendDataBlock.getRows());
        arrayObjectAdapter.addAll(0,recommendDataBlock.getRows());
        Log.d(TAG, "initRecommendData: " + recommendDataBlock.getRows());
    }

    private void initPoster(){
        Log.d(TAG, "initPoster: ");
        MovieData movieData = new MovieData(mContext);
        listRowPresenter.addRowConfig(Poster.class, new RowConfig(new RowConfig.RowMargin(-8, 0), 4, 0));
        Block<Poster.Resource> posterBlock = new Block<>(null, movieData.getData(),6);
        posterBlock.createRows(presenterSelector);
        arrayObjectAdapter.addAll(0,posterBlock.getRows());
        Log.d(TAG, "initPoster: "+posterBlock.getRows());

    }

    private void initComic(){
        ComicData comicData = new ComicData(mContext);
        Block<Poster.Resource> comicBlock = new Block<>(null, comicData.getData(), 5);
        comicBlock.createRows(presenterSelector);
        arrayObjectAdapter.addAll(0,comicBlock.getRows());
    }

    private void initGame(){
        GameData gameData = new GameData(mContext);
        Block<Poster.Resource> gameBlock = new Block<>(null, gameData.getData(), 5);
        gameBlock.createRows(presenterSelector);
        arrayObjectAdapter.addAll(0,gameBlock.getRows());
    }

    private void initSport(){
        SportData sportData = new SportData(mContext);
        Block<NBATeamsName.ResourcesDTO> eastTeamBlock = new Block<>("东部球队", sportData.getEastTeam(), 20);
        eastTeamBlock.createRows(presenterSelector);
        arrayObjectAdapter.addAll(0,eastTeamBlock.getRows());
        Block<NBATeamsName.ResourcesDTO> westTeamBlock = new Block<>("西部球队", sportData.getWestTeam(), 20);
        westTeamBlock.createRows(presenterSelector);
        arrayObjectAdapter.addAll(0,westTeamBlock.getRows());

    }

    private void onRecommendClick(Recommend.ResourcesDTO recommend){
        Log.d(TAG, "onRecommendClick: " + getAllApps().toString());
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(recommend.getPackageName());
        if(intent != null){
            mContext.startActivity(intent);
        }else{
            Toast.makeText(mContext, "没有下载该应用", Toast.LENGTH_SHORT).show();
        }
    }

    private List<PackageInfo> getAllApps(){
        List<PackageInfo> apps = new ArrayList<>();
        PackageManager packageManager = mContext.getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        @SuppressLint("QueryPermissionsNeeded") List<PackageInfo> appList = packageManager.getInstalledPackages(0);
        for(PackageInfo packageInfo : appList){
            Log.d(TAG, "getAllApps: " + packageInfo);
        }

        return apps;
    }

}
