package com.example.hdstv.fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.FocusHighlightHelper;
import androidx.leanback.widget.ItemBridgeAdapter;

import com.example.hdstv.Presenter.MyHeaderPresenter;
import com.example.hdstv.Presenter.MyListRowPresenter;
import com.example.hdstv.Presenter.PosterPresenter;
import com.example.hdstv.Presenter.RecommendPresenter;
import com.example.hdstv.bean.Block;
import com.example.hdstv.bean.Poster;
import com.example.hdstv.bean.Recommend;
import com.example.hdstv.bean.RecommendData;
import com.example.hdstv.bean.RowConfig;
import com.example.hdstv.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePageFragment extends RowsSupportFragment {

    Context mContext;
    List<Poster> posters;
    Recommend recommends;
    List<Poster.Resource> posterResources;
    List<Recommend.ResourcesDTO> recommendResources;
    ArrayObjectAdapter arrayObjectAdapter;
    ClassPresenterSelector presenterSelector;
    private MyHeaderPresenter mHeaderPresenter;
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

        MyListRowPresenter listRowPresenter = initMyListRowPresenter();
        arrayObjectAdapter = new ArrayObjectAdapter(listRowPresenter);
        getVerticalGridView().setVerticalSpacing(40);
        getVerticalGridView().setPadding(90,56,90,120);
        setAdapter(arrayObjectAdapter);


        try {
            initData();
            initPresenterSelector();
            initPoster();
            initRecommendData();
            Log.d(TAG, "onViewCreated: " + getVerticalGridView().getChildAt(0));
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG,"err: "+e.getMessage());
        }

    }

    private MyListRowPresenter initMyListRowPresenter() {
        MyListRowPresenter presenter = new MyListRowPresenter();
        presenter.addRowConfig(Poster.class, new RowConfig(new RowConfig.RowMargin(-8, 0), 4, 0));
        presenter.addRowConfig(RecommendData.class, new RowConfig(new RowConfig.RowMargin(47,40), 7,0));

        mHeaderPresenter = new MyHeaderPresenter(mContext);
        presenter.setHeaderPresenter(mHeaderPresenter);

        presenter.setSelectEffectEnabled(false);


        return presenter;
    }

    @Override
    public void onResume() {
        super.onResume();

    }




    private void initData(){
        String posterJson = StringUtils.readAssetsFile("home1.json", mContext);
        String recommendJson = StringUtils.readAssetsFile("ApplicationContentBean.json",mContext);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Poster>>(){}.getType();
        posters = gson.fromJson(posterJson, type);
//        Gson gson1 = new Gson();
        Type type1 = new TypeToken<Recommend>(){}.getType();
        recommends = gson.fromJson(recommendJson,type1);
        Log.d(TAG, "initData: " + posters.toString());
        Log.d(TAG, "initData: " + recommends.toString());
        posterResources = posters.get(0).getResources();
        recommendResources = recommends.getResources();
        Log.d(TAG, "selectData: " + posterResources.toString());
    }



    public void notifyData(int currentPosition){
        arrayObjectAdapter.clear();
        this.curTabPosition = currentPosition;
        selectData(currentPosition);
        arrayObjectAdapter.addAll(0, posterResources);
    }

    private void selectData(int curPosition){
        posterResources = posters.get(curPosition).getResources();
        Log.d(TAG, "selectData: " + posterResources.toString());
    }

//    public void dispatchKeyEvent(KeyEvent event){
//        int action = event.getAction();
//        int keyCode = event.getKeyCode();
//        Log.d(TAG,"fragAction:"+action+"   keyCode: "+keyCode +"   position: "+verticalGridView.getSelectedPosition());
//        if(verticalGridView.getSelectedPosition() < COLUMNS && keyCode == KeyEvent.KEYCODE_DPAD_UP){
//            Log.d(TAG,"dpad_up");
//            //((ScreenSlidePagerActivity)requireActivity()).getTabLayout().requestFocus();
//        }
//    }

//    public VerticalGridView getVerticalGridView(){
//        return verticalGridView;
//    }

    private void initPresenterSelector(){
        presenterSelector = new ClassPresenterSelector();
        presenterSelector.addClassPresenter(Recommend.ResourcesDTO.class,new RecommendPresenter());
        presenterSelector.addClassPresenter(Poster.Resource.class,new PosterPresenter());
    }


    private void initRecommendData(){
        Block<Recommend.ResourcesDTO> recommendDataBlock = new Block<>("推荐",recommendResources,8);
        recommendDataBlock.createRows(presenterSelector);
        Log.d(TAG,"rowSize: "+recommendDataBlock.getRows());
        arrayObjectAdapter.addAll(0,recommendDataBlock.getRows());
        Log.d(TAG, "initRecommendData: " + recommendDataBlock.getRows());

    }

    private void initPoster(){
        Log.d(TAG, "initPoster: ");
        Block<Poster.Resource> posterBlock = new Block<>("海报", posterResources,5);
        posterBlock.createRows(presenterSelector);
        arrayObjectAdapter.addAll(0,posterBlock.getRows());
        Log.d(TAG, "initPoster: "+posterBlock.getRows());

    }

    private void requestFirstChildFocus() {
        mUiHandler.post(new Runnable() {
            @Override
            public void run() {
                if (getVerticalGridView() != null) {
                    Log.d(TAG, "run: " + getVerticalGridView().getChildAt(0));
                    View view = getVerticalGridView().getChildAt(0);
                    if (view != null) {
                        view.requestFocus();
                        FocusHighlightHelper.setupHeaderItemFocusHighlight(new ItemBridgeAdapter());
                    }
                }
            }
        });
    }


}
