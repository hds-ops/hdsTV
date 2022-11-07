package com.example.hdstv.fragment;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.FocusHighlightHelper;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.VerticalGridView;

import com.example.hdstv.Activity.ScreenSlidePagerActivity;
import com.example.hdstv.Presenter.VerticalPresenter;
import com.example.hdstv.R;
import com.example.hdstv.bean.Poster;
import com.example.hdstv.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePageFragment extends Fragment {

    Context mContext;
    VerticalGridView verticalGridView;
    List<Poster> posters;
    List<Poster.Resource> resources;
    ArrayObjectAdapter arrayObjectAdapter;
    int curTabPosition;
    public static final int columns = 5;
    private static final String TAG = ScreenSlidePageFragment.class.getSimpleName();

    public ScreenSlidePageFragment(Context context){
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_slide_page,container,false);
        curTabPosition = ((ScreenSlidePagerActivity)requireActivity()).getCurrTabPosition();
        initData();
        selectData(curTabPosition);
        initView(view);
        notifyData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        curTabPosition = ((ScreenSlidePagerActivity)requireActivity()).getCurrTabPosition();
        Log.d(TAG,"  "+curTabPosition);

    }

    private void initView(View view){
        verticalGridView = view.findViewById(R.id.fragment_vertical_grid_view);
        verticalGridView.setNumColumns(columns);
        VerticalPresenter verticalPresenter = new VerticalPresenter();
        arrayObjectAdapter = new ArrayObjectAdapter(verticalPresenter);

        ItemBridgeAdapter bridgeAdapter = new ItemBridgeAdapter(arrayObjectAdapter);
        verticalGridView.setAdapter(bridgeAdapter);
        verticalGridView.requestFocus();
        FocusHighlightHelper.setupHeaderItemFocusHighlight(bridgeAdapter);
    }


    public VerticalGridView getVerticalGridView(){
        return verticalGridView;
    }

    private void initData(){

        String json = StringUtils.readAssetsFile("home1.json", mContext);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Poster>>(){}.getType();
        posters = gson.fromJson(json, type);

        Log.d("TAG", "initData: " + posters);

        resources = posters.get(curTabPosition).getResources();
        Log.d(TAG, "selectData: " + resources.toString());
    }



    public void notifyData(){
        arrayObjectAdapter.addAll(0,resources);
    }

    private void selectData(int curPosition){
        resources = posters.get(curPosition).getResources();
        Log.d(TAG, "selectData: " + resources.toString());
    }

    public void dispatchKeyEvent(KeyEvent event){
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        Log.d(TAG,"fragAction:"+action+"   keyCode: "+keyCode +"   position: "+verticalGridView.getSelectedPosition());
        if(verticalGridView.getSelectedPosition() < columns && keyCode == KeyEvent.KEYCODE_DPAD_UP){
            Log.d(TAG,"dpad_up");
            ((ScreenSlidePagerActivity)requireActivity()).getTabLayout().requestFocus();
        }
    }


}
